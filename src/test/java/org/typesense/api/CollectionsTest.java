package org.typesense.api;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.model.CollectionResponse;
import org.typesense.model.CollectionSchema;
import org.typesense.model.Field;

import junit.framework.TestCase;


public class CollectionsTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(CollectionsTest.class);
    public TypesenseClient client;
    private Helper helper;

    public void setUp() throws Exception {
        super.setUp();
        helper = new Helper();
        this.client = helper.getClient();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        helper.teardown();
    }


    @Test
    public void testRetrieveAllCollections() throws Exception {
        helper.createTestCollection();
        CollectionResponse[] collectionResponses = client.collections().retrieve();
        for (CollectionResponse c : collectionResponses) {
            log.debug(String.valueOf(c));
        }
    }

    @Test
    public void testRetrieveSingleCollection() throws Exception {
        helper.createTestCollection();
        log.debug(String.valueOf(client.collections("books").retrieve()));
    }

    @Test
    public void testDeleteCollection() throws Exception {
        helper.createTestCollection();
        log.debug(String.valueOf(client.collections("books").delete()));
    }

    @Test
    public void testCreateCollection() throws Exception {

        ArrayList<Field> fields = new ArrayList<>();
        fields.add(new Field().name("countryName").type(FieldTypes.STRING));
        fields.add(new Field().name("capital").type(FieldTypes.STRING));
        fields.add(new Field().name("gdp").type(FieldTypes.INT32).facet(true));

        CollectionSchema collectionSchema = new CollectionSchema();
        collectionSchema.name("Countries").fields(fields);

        CollectionResponse cr = client.collections().create(collectionSchema);
        log.debug(String.valueOf(cr));
    }
}
