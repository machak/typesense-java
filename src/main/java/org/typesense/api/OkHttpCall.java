package org.typesense.api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.interceptor.RetryInterceptor;
import org.typesense.resources.Node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpCall extends BaseCall {

    public static final byte[] EMPTY_BYTES = {};
    private final Configuration configuration;
    private final ObjectMapper mapper = new ObjectMapper();

    private static int nodeIndex = 0;

    private static final String API_KEY_HEADER = "X-TYPESENSE-API-KEY";
    private static final Logger log = LoggerFactory.getLogger(OkHttpCall.class);
    private final OkHttpClient client;
    private final String apiKey;

    public OkHttpCall(Configuration configuration) {
        this.configuration = configuration;
        this.apiKey = configuration.apiKey;
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        client = new OkHttpClient.Builder()
                .connectTimeout(configuration.connectionTimeout.getSeconds(), TimeUnit.SECONDS)
                // TODO add read timeout
                .readTimeout(configuration.connectionTimeout.getSeconds(), TimeUnit.SECONDS)
                .addInterceptor(new RetryInterceptor(configuration.numRetries))
                .build();

    }

    @Override
    public boolean isDueForHealthCheck(Node node) {
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

    @Override
    public void setNodeHealthStatus(Node node, boolean status) {
        node.isHealthy = status;
        node.lastAccessTimestamp = LocalDateTime.now();
    }


    @Override
    public <T, Q> T get(final String endpoint, Q queryParameters, Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        populateQueryParameters2(urlBuilder, queryParameters);
        final Request request = createGetRequest(urlBuilder);
        return processRequest(request, resourceClass);
    }


    @Override
    public <T> T get(final String endpoint, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final Request request = createGetRequest(urlBuilder);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T> T get(String endpoint) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final Request request = createGetRequest(urlBuilder);
        return processRequest(request, null);
    }

    @Override
    public <T, R> T put(final String endpoint, final R body, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPutRequest(urlBuilder, responseBody);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T, R> T patch(final String endpoint, final R body, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPatchRequest(urlBuilder, responseBody);
        return processRequest(request, resourceClass);
    }


    @Override
    public <T, R> T post(final String endpoint, final R body, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T> T post(final String endpoint, final T body) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, null);
    }


    @Override
    public <T, R, Q> T post(final String endpoint, final R body, final Q queryParameters, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        populateQueryParameters2(urlBuilder, queryParameters);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T> T post(final String endpoint, Map<String, String> queryParameters) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        populateQueryParameters2(urlBuilder, queryParameters);
        final RequestBody responseBody = RequestBody.create(EMPTY_BYTES, null);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, null);
    }

    @Override
    public <T> T post(String endpoint, final Map<String, List<Map<String, String>>> body, final Map<String, String> queryParameters, final Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        populateQueryParameters(urlBuilder, queryParameters);
        final RequestBody responseBody = createRequestBody(body);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T> T post(final String endpoint) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final RequestBody responseBody = RequestBody.create(EMPTY_BYTES, null);
        final Request request = createPostRequest(urlBuilder, responseBody);
        return processRequest(request, null);
    }

    @Override
    public <T, Q> T delete(final String endpoint, final Q queryParameters) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        populateQueryParameters2(urlBuilder, queryParameters);
        final Request request = createDeleteRequest(urlBuilder);
        return processRequest(request, null);
    }


    @Override
    public <T> T delete(String endpoint, Class<T> resourceClass) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final Request request = createDeleteRequest(urlBuilder);
        return processRequest(request, resourceClass);
    }

    @Override
    public <T> T delete(final String endpoint) throws Exception {
        final HttpUrl.Builder urlBuilder = createUrl(endpoint);
        final Request request = createDeleteRequest(urlBuilder);
        return processRequest(request, null);
    }


    public <T> T processRequest(final Request request, final Class<T> resourceClass) throws Exception {

        final Call call = client.newCall(request);
        try (Response response = call.execute()) {
            final String result = response.body() != null ? response.body().string() : null;
            return mapper.readValue(result, resourceClass);

        } catch (Exception e) {
            log.error("Error processing request", e);
        }


        // TODO fix..
        return null;
    }

    private HttpUrl.Builder populateQueryParameters(HttpUrl.Builder builder, Map<String, String> queryParameters) {
        if (queryParameters != null) {
            for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder;
    }

    private <T> HttpUrl.Builder populateQueryParameters2(HttpUrl.Builder builder, T queryParameters) {
        if (queryParameters != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.convertValue(queryParameters, Map.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                StringBuilder value = new StringBuilder();
                if (entry.getValue() instanceof ArrayList) {
                    extractParameters(entry, value);
                    builder.addQueryParameter(entry.getKey(), String.valueOf(value));
                } else {
                    builder.addQueryParameter(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return builder;
    }

    @NotNull
    private <R> RequestBody createRequestBody(final R body) throws JsonProcessingException {
        final String json = mapper.writeValueAsString(body);
        return RequestBody.create(json, MediaType.parse("application/json"));
    }

    @NotNull
    private HttpUrl.Builder createUrl(final String endpoint) {
        final Node node = getNode();
        final String URI = node.baseUrl;
        final String url = URI + endpoint;
        return HttpUrl.parse(url).newBuilder();
    }

    @NotNull
    private Request createPutRequest(final HttpUrl.Builder urlBuilder, final RequestBody body) {
        return new Request.Builder()
                .addHeader(API_KEY_HEADER, apiKey)
                .addHeader("Content-Type", "application/json")
                .url(urlBuilder.build())
                .put(body)
                .build();
    }

    @NotNull
    private Request createPatchRequest(final HttpUrl.Builder urlBuilder, final RequestBody body) {
        return new Request.Builder()
                .addHeader(API_KEY_HEADER, apiKey)
                .addHeader("Content-Type", "application/json")
                .url(urlBuilder.build())
                .patch(body)
                .build();
    }

    @NotNull
    private Request createPostRequest(final HttpUrl.Builder urlBuilder, final RequestBody body) {
        return new Request.Builder()
                .addHeader(API_KEY_HEADER, apiKey)
                .addHeader("Content-Type", "application/json")
                .url(urlBuilder.build())
                .post(body)
                .build();
    }

    @NotNull
    private Request createDeleteRequest(final HttpUrl.Builder urlBuilder) {
        return new Request.Builder()
                .addHeader(API_KEY_HEADER, apiKey)
                .addHeader("Content-Type", "application/json")
                .url(urlBuilder.build())
                .delete()
                .build();
    }

    @NotNull
    private Request createGetRequest(final HttpUrl.Builder urlBuilder) {
        return new Request.Builder()
                .addHeader(API_KEY_HEADER, apiKey)
                .addHeader("Content-Type", "application/json")
                .url(urlBuilder.build())
                .get()
                .build();
    }
}

