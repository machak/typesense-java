package org.typesense.api;

import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;

import org.typesense.resources.Node;

import junit.framework.TestCase;

public class RetryTest extends TestCase {

    private TypesenseClient client;

    public void setUp() throws Exception {
        super.setUp();
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node("http", "unknownhost123", "8108"));
        Configuration configuration = new Configuration(nodes, Duration.ofSeconds(1), "xyz");
        configuration.numRetries = 2;
        configuration.retryInterval = Duration.ofSeconds(2);
        this.client = new JerseyClient(configuration);
    }

    public void testRetry() throws Exception {
        long start = System.currentTimeMillis();
        try {
            client.getHealth().retrieve();
        } catch (Exception e) {
            long timeTaken = System.currentTimeMillis() - start;
            assertTrue(e.getCause() instanceof UnknownHostException);
            assertTrue(timeTaken > 4000);
            return;
        }

        throw new Exception("Retry did not throw exception.");
    }
}
