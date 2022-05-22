package org.typesense.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.model.ApiKey;
import org.typesense.model.ApiKeySchema;

import junit.framework.TestCase;

public class KeysTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(KeysTest.class);
    private TypesenseClient client;
    private Helper helper;
    private String testKey;
    private Long id;

    public void setUp() throws Exception {
        super.setUp();
        helper = new Helper();
        client = helper.getClient();
        ApiKey key = helper.createTestKey();
        testKey = key.getValue();
        id = key.getId();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        helper.teardown();
    }

    public void testCreate() throws Exception {
        ApiKeySchema apiKeySchema = new ApiKeySchema();
        List<String> actionValues = new ArrayList<>();
        List<String> collectionValues = new ArrayList<>();

        actionValues.add("*");
        collectionValues.add("*");

        apiKeySchema.description("Admin Key").actions(actionValues).collections(collectionValues);

        log.debug(String.valueOf(client.keys().create(apiKeySchema)));
    }

    public void testCreateSearchOnly() throws Exception {
        ApiKeySchema apiKeySchema = new ApiKeySchema();
        List<String> actionValues = new ArrayList<>();
        List<String> collectionValues = new ArrayList<>();

        actionValues.add("documents:search");
        collectionValues.add("books");

        apiKeySchema.description("Search only Key").actions(actionValues).collections(collectionValues);

        log.debug(String.valueOf(this.client.keys().create(apiKeySchema)));
    }

    public void testRetrieve() throws Exception {
        log.debug(String.valueOf(this.client.keys(id).retrieve()));
    }

    public void testRetrieveAll() throws Exception {
        log.debug(String.valueOf(client.keys().retrieve()));
    }

    public void testDelete() throws Exception {
        log.debug(String.valueOf(this.client.keys(id).delete()));
    }

    public void testScopedKey() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("filter_by", "company_id:124");
        log.debug(this.client.keys().generateScopedSearchKey(testKey, parameters));
    }
}
