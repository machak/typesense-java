package org.typesense.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.model.CollectionAlias;
import org.typesense.model.CollectionAliasSchema;
import org.typesense.model.CollectionAliasesResponse;

import junit.framework.TestCase;

public class AliasesTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(AliasesTest.class);
    private TypesenseClient client;
    private Helper helper;

    public void setUp() throws Exception {
        super.setUp();
        helper = new Helper();
        client = helper.getClient();
        helper.createTestAlias();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        helper.teardown();
    }

    public void testUpsert() throws Exception {
        CollectionAliasSchema collectionAliasSchema = new CollectionAliasSchema();
        collectionAliasSchema.collectionName("books_june11");

        log.debug(String.valueOf(client.aliases().upsert("books1", collectionAliasSchema)));
    }

    public void testRetrieveAll() throws Exception {
        CollectionAliasesResponse collectionAliasesResponse = client.aliases().retrieve();

        log.debug(String.valueOf(collectionAliasesResponse));
    }

    public void testRetrieveSingleAlias() throws Exception {
        CollectionAlias collectionAlias = client.aliases("books").retrieve();

        log.debug(String.valueOf(collectionAlias));
    }

    public void testDelete() throws Exception {
        CollectionAlias collectionAlias = client.aliases("books").delete();

        log.debug(String.valueOf(collectionAlias));
    }
}
