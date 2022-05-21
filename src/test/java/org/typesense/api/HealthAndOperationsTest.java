package org.typesense.api;

import java.util.HashMap;

import junit.framework.TestCase;

public class HealthAndOperationsTest extends TestCase {

    private Client client;
    private Helper helper;

    public void setUp() throws Exception {
        super.setUp();
        helper = new Helper();
        client = helper.getClient();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        helper.teardown();
    }

    public void testRetrieve() throws Exception {
        System.out.println(this.client.health.retrieve());
    }

    public void testPerformSnapshot() throws Exception {
        HashMap<String, String> query = new HashMap<>();
        query.put("snapshot_path", "/tmp/typesense-data-snapshot");
        System.out.println(client.operations.perform("snapshot", query));
    }

    public void testPerformVote() throws Exception {
        System.out.println(client.operations.perform("vote"));
    }

    public void testMetrics() throws Exception {
        System.out.println(client.metrics.retrieve());
    }

    public void testDebug() throws Exception {
        System.out.println(client.debug.retrieve());
    }
}
