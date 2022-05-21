package org.typesense.interceptor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.glassfish.jersey.client.spi.PostInvocationInterceptor;
import org.glassfish.jersey.client.spi.PreInvocationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientResponseContext;

public class LoggingInterceptor implements PreInvocationInterceptor, PostInvocationInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void beforeRequest(ClientRequestContext requestContext) {
        if (logger.isTraceEnabled()) {
            try {
                String json = objectMapper.writeValueAsString(requestContext.getEntity());
                logger.trace("REQUEST URI    : " + requestContext.getUri().toString());
                logger.trace("REQUEST METHOD : " + requestContext.getMethod());
                logger.trace("REQUEST ENTITY : " + json);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void afterRequest(ClientRequestContext requestContext, ClientResponseContext responseContext) {
        /*if (logger.isTraceEnabled()) {
            logger.trace("RESPONSE STATUS: " + responseContext.getStatus()
                    + "/" + responseContext.getStatusInfo());
            // TODO: Consuming the below input stream closes it for subsequent clients
            //logger.trace("RESPONSE BODY: " + inputStreamToString(responseContext.getEntityStream()));
        }*/
    }

    @Override
    public void onException(ClientRequestContext requestContext, ExceptionContext exceptionContext) {
    }

    private String inputStreamToString(InputStream is) {
        return new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
    }
}
