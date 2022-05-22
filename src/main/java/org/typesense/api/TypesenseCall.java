package org.typesense.api;

import java.util.List;
import java.util.Map;

import org.typesense.resources.Node;

public interface TypesenseCall {
    boolean isDueForHealthCheck(Node node);

    void setNodeHealthStatus(Node node, boolean status);

    <T, Q> T get(String endpoint, Q queryParameters, Class<T> resourceClass) throws Exception;

    <T> T get(String endpoint, Class<T> resourceClass) throws Exception;

    abstract <T> T get(String endpoint) throws Exception;

    abstract <T, R> T put(String endpoint, R body, Class<T> resourceClass) throws Exception;

    abstract <T, R> T patch(String endpoint, R body, Class<T> resourceClass) throws Exception;

    abstract <T, R> T post(String endpoint, R body, Class<T> resourceClass) throws Exception;

    abstract <T> T post(String endpoint, T body) throws Exception;

    <T, R, Q> T post(String endpoint, R body, Q queryParameters, Class<T> resourceClass) throws Exception;

    abstract <T> T post(String endpoint, Map<String, String> queryParameters) throws Exception;

    abstract <T> T post(String endpoint, Map<String, List<Map<String, String>>> body, Map<String, String> queryParameters, Class<T> resourceClass) throws Exception;

    abstract <T> T post(String endpoint) throws Exception;

    abstract <T, Q> T delete(String endpoint, Q queryParameters) throws Exception;

    abstract <T> T delete(String endpoint, Class<T> resourceClass) throws Exception;

    <T> T delete(String endpoint) throws Exception;


}
