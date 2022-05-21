package org.typesense.api;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.api.exceptions.HttpError;
import org.typesense.api.exceptions.ObjectAlreadyExists;
import org.typesense.api.exceptions.ObjectNotFound;
import org.typesense.api.exceptions.ObjectUnprocessable;
import org.typesense.api.exceptions.RequestForbidden;
import org.typesense.api.exceptions.RequestMalformed;
import org.typesense.api.exceptions.RequestUnauthorized;
import org.typesense.api.exceptions.ServerError;
import org.typesense.api.exceptions.ServiceUnavailable;
import org.typesense.api.exceptions.TypesenseError;
import org.typesense.model.ErrorResponse;
import org.typesense.resources.Node;
import org.typesense.resources.RequestHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class ApiCall {

    private final Configuration configuration;

    private static int nodeIndex = 0;

    private static final String API_KEY_HEADER = "X-TYPESENSE-API-KEY";
    private static final Logger log = LoggerFactory.getLogger(ApiCall.class);
    private final Client client;
    private final String apiKey;
    private final Duration retryInterval;

    public ApiCall(Configuration configuration) {
        this.configuration = configuration;
        List<Node> nodes = configuration.nodes;
        this.apiKey = configuration.apiKey;
        this.retryInterval = configuration.retryInterval;

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.connectorProvider(new ApacheConnectorProvider());


        JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider();
        ObjectMapper objectMapper = jacksonJsonProvider.locateMapper(
                Object.class, MediaType.APPLICATION_JSON_TYPE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        this.client = ClientBuilder.newClient(clientConfig)
                                   .register(jacksonJsonProvider);
        this.client.property(ClientProperties.CONNECT_TIMEOUT, configuration.connectionTimeout.getSeconds() * 1000);
        this.client.property(ClientProperties.READ_TIMEOUT, configuration.connectionTimeout.getSeconds() * 1000);
    }

    boolean isDueForHealthCheck(Node node) {
        return Duration.between(node.lastAccessTimestamp, LocalDateTime.now()).getSeconds() > configuration.healthCheckInterval.getSeconds();
    }

    //Loops in a round-robin fashion to check for a healthy node and returns it
    Node getNode() {
        if (configuration.nearestNode != null) {
            if (isDueForHealthCheck((configuration.nearestNode)) || configuration.nearestNode.isHealthy) {
                return configuration.nearestNode;
            }
        }

        int i = 0;
        Node testNode;

        while (i < configuration.nodes.size()) {
            testNode = configuration.nodes.get(nodeIndex);

            if (testNode.isHealthy || isDueForHealthCheck((testNode))) {
                return testNode;
            }

            i += 1;
            nodeIndex = (nodeIndex + 1) % configuration.nodes.size();
        }

        return configuration.nodes.get(nodeIndex);
    }

    void setNodeHealthStatus(Node node, boolean status) {
        node.isHealthy = status;
        node.lastAccessTimestamp = LocalDateTime.now();
    }

    private TypesenseError getException(Response response) {
        ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
        String message = errorResponse.getMessage();
        int status_code = response.getStatus();

        if (status_code == 400) {
            return new RequestMalformed(message, status_code);
        } else if (status_code == 401) {
            return new RequestUnauthorized(message, status_code);
        } else if (status_code == 403) {
            return new RequestForbidden(message, status_code);
        } else if (status_code == 404) {
            return new ObjectNotFound(message, status_code);
        } else if (status_code == 409) {
            return new ObjectAlreadyExists(message, status_code);
        } else if (status_code == 422) {
            return new ObjectUnprocessable(message, status_code);
        } else if (status_code == 500) {
            return new ServerError(message, status_code);
        } else if (status_code == 503) {
            return new ServiceUnavailable(message, status_code);
        } else {
            return new HttpError(message, status_code);
        }
    }

    <T, Q> T get(String endpoint, Q queryParameters, Class<T> resourceClass) throws Exception {

        /*
         * Lambda function which implements the RequestHandler interface
         * which is passed as a parameter to makeRequest function
         * and returns T as the response entity.
         * This is similar for all type of requests.
         */
        RequestHandler r = (String REST_URI) -> populateQueryParameters2(this.client.target(REST_URI), queryParameters)
                .request(MediaType.APPLICATION_JSON)
                .header(API_KEY_HEADER, apiKey)
                .get();

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T get(String endpoint, Class<T> resourceClass) throws Exception {
        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .get();

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T get(String endpoint) throws Exception {
        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON_TYPE)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .get();

        return makeRequest(endpoint, r, null);
    }

    <T, R> T put(String endpoint, R body, Class<T> resourceClass) throws Exception {

        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .put(Entity.json(body));

        return makeRequest(endpoint, r, resourceClass);
    }

    <T, R> T patch(String endpoint, R body, Class<T> resourceClass) throws Exception {

        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .build("PATCH", Entity.entity(body, MediaType.APPLICATION_JSON))
                                                           .invoke();

        return makeRequest(endpoint, r, resourceClass);
    }


    <T, R> T post(String endpoint, R body, Class<T> resourceClass) throws Exception {

        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .post(Entity.json(body));

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T post(String endpoint, T body) throws Exception {

        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .post(Entity.json(body));

        return makeRequest(endpoint, r, null);
    }


    <T, R, Q> T post(String endpoint, R body, Q queryParameters, Class<T> resourceClass) throws Exception {

        RequestHandler r = (String REST_URI) -> populateQueryParameters2(this.client.target(REST_URI), queryParameters)
                .request(MediaType.APPLICATION_JSON)
                .header(API_KEY_HEADER, apiKey)
                .post(Entity.json(body));

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T post(String endpoint, HashMap<String, String> queryParameters) throws Exception {

        RequestHandler r = (String REST_URI) -> populateQueryParameters(this.client.target(REST_URI), queryParameters)
                .request(MediaType.APPLICATION_JSON)
                .header(API_KEY_HEADER, apiKey)
                .post(Entity.json(null));

        return makeRequest(endpoint, r, null);
    }

    <T> T post(String endpoint, HashMap<String, List<HashMap<String, String>>> body, HashMap<String, String> queryParameters, Class<T> resourceClass) throws Exception {

        RequestHandler r = (String REST_URI) -> populateQueryParameters(this.client.target(REST_URI), queryParameters)
                .request(MediaType.APPLICATION_JSON)
                .header(API_KEY_HEADER, apiKey)
                .post(Entity.json(body));

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T post(String endpoint) throws Exception {

        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .post(Entity.json(null));

        return makeRequest(endpoint, r, null);
    }

    <T, Q> T delete(String endpoint, Q queryParameters) throws Exception {
        RequestHandler r = (String REST_URI) -> populateQueryParameters2(this.client.target(REST_URI), queryParameters)
                .request(MediaType.APPLICATION_JSON)
                .header(API_KEY_HEADER, apiKey)
                .delete();

        return makeRequest(endpoint, r, null);
    }


    <T> T delete(String endpoint, Class<T> resourceClass) throws Exception {
        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .delete();

        return makeRequest(endpoint, r, resourceClass);
    }

    <T> T delete(String endpoint) throws Exception {
        RequestHandler r = (String REST_URI) -> this.client.target(REST_URI)
                                                           .request(MediaType.APPLICATION_JSON)
                                                           .header(API_KEY_HEADER, apiKey)
                                                           .delete();

        return makeRequest(endpoint, r, null);
    }

    /**
     * Actual function which makes the http request
     *
     * @param endpoint       particular endpoint of the resource
     * @param requestHandler lambda function interface for the particular request
     * @param <T>            response entity
     * @return http response
     */

    <T> T makeRequest(String endpoint, RequestHandler requestHandler, Class<T> resourceClass) throws Exception {
        int num_tries = 0;
        Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        Response response;
        Exception lastException = new TypesenseError("Unknown client error", 400);

        while (num_tries < this.configuration.numRetries) {
            num_tries += 1;
            Node node = this.getNode();
            String URI = node.baseUrl;

            try {
                String url = URI + endpoint;
                response = requestHandler.handleRequest(url);

                if (response.getStatus() < 500) {
                    // any non-50x status code means that the node is healthy
                    this.setNodeHealthStatus(node, true);
                }

                if (response.getStatus() >= 200 && response.getStatus() < 300) {
                    return handleResponse(response, resourceClass);
                }

                throw getException(response);

            } catch (Exception e) {
                boolean handleError = (e instanceof ServerError) ||
                        (e instanceof ServiceUnavailable) ||
                        (e.getCause() instanceof SocketTimeoutException) ||
                        (e.getCause() instanceof UnknownHostException) ||
                        (e.getCause() instanceof SSLException);

                if (!handleError) {
                    // we just throw and move on
                    throw e;
                }

                this.setNodeHealthStatus(node, false);
                lastException = e;
                logger.trace("Request to {} failed because: {}", node.host, e.getMessage());
                logger.trace("Sleeping for {}s and then retrying request", this.retryInterval.getSeconds());
                try {
                    Thread.sleep(this.retryInterval.getSeconds() * 1000);
                } catch (InterruptedException interruptedException) {
                    logger.error("Error while sleeping.", interruptedException);
                }
            }
        }

        throw lastException;
    }


    /**
     * Adds query parameters to the http request
     *
     * @param client          WebTarget object pointing to the required endpoint
     * @param queryParameters Map of the query parameters
     * @return WebTarget with the query parameters added
     */

    private WebTarget populateQueryParameters(WebTarget client, HashMap<String, String> queryParameters) {
        if (queryParameters != null) {
            for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
                client = client.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return client;
    }

    private <T> WebTarget populateQueryParameters2(WebTarget client, T queryParameters) {
        if (queryParameters != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.convertValue(queryParameters, Map.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                StringBuilder value = new StringBuilder();
                if (entry.getValue() instanceof ArrayList) {
                    for (int i = 0; i < ((ArrayList<?>) entry.getValue()).size(); i++) {
                        value.append(((ArrayList<?>) entry.getValue()).get(i));
                        if (i != ((ArrayList<?>) entry.getValue()).size() - 1) {
                            value.append(',');
                        }
                    }
                    client = client.queryParam(entry.getKey(), value);
                } else {
                    client = client.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        return client;
    }

    /**
     * Function to create a map from the json response
     *
     * @param response Jersey Response object
     * @param <T>
     * @return HashMap containing the response
     */

    <T> T handleResponse(Response response, Class<T> resourceClass) {
        if (resourceClass == null) {
            ObjectMapper mapper = new ObjectMapper();
            String json = response.readEntity(String.class);
            try {
                Map<String, Object> map = mapper.readValue(json, HashMap.class);
                return (T) map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ObjectMapperResolver resolver = new ObjectMapperResolver();
            ObjectMapper mapper = resolver.getContext(String.class);
            String json = response.readEntity(String.class);
            try {
                if (resourceClass == String.class) {
                    //noinspection unchecked
                    return (T) json;
                }
                return mapper.readValue(json, resourceClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

