package org.typesense.api;

import java.time.Duration;
import java.util.List;

import org.typesense.resources.Node;

public class Configuration {

    public final List<Node> nodes;
    public Node nearestNode;
    public final Duration connectionTimeout;
    public final Duration healthCheckInterval;
    public int numRetries;
    public Duration retryInterval;
    public final String apiKey;
    public final boolean sendApiKeyAsQueryParam;

    /**
     * @param nodes             List of Nodes
     * @param connectionTimeout Duration in seconds
     * @param apiKey            String describing the apiKey
     */

    public Configuration(List<Node> nodes, Duration connectionTimeout, String apiKey) {
        this.nodes = nodes;
        this.connectionTimeout = connectionTimeout;
        this.apiKey = apiKey;

        this.healthCheckInterval = Duration.ofSeconds(60);
        this.numRetries = 3;
        this.retryInterval = Duration.ofSeconds(3);
        this.sendApiKeyAsQueryParam = false;
    }

    public Configuration(Node nearestNode, List<Node> nodes, Duration connectionTimeout, String apiKey) {
        this(nodes, connectionTimeout, apiKey);
        this.nearestNode = nearestNode;
    }
}
