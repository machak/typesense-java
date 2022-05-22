package org.typesense.api;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class HealthAndOperationsTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(HealthAndOperationsTest.class);
    private TypesenseClient client;
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
        log.debug(String.valueOf(this.client.getHealth().retrieve()));
    }

    public void testPerformSnapshot() throws Exception {
        HashMap<String, String> query = new HashMap<>();
        query.put("snapshot_path", "/tmp/typesense-data-snapshot");
        log.debug(String.valueOf(client.getOperations().perform("snapshot", query)));
    }

    public void testPerformVote() throws Exception {
        log.debug(String.valueOf(client.getOperations().perform("vote")));
    }

    public void testMetrics() throws Exception {
        log.debug(String.valueOf(client.getMetrics().retrieve()));
    }

    public void testDebug() throws Exception {
        log.debug(String.valueOf(client.getDebug().retrieve()));
    }
}
