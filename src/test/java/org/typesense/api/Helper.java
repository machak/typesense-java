package org.typesense.api;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.typesense.model.ApiKey;
import org.typesense.model.ApiKeySchema;
import org.typesense.model.ApiKeysResponse;
import org.typesense.model.CollectionAlias;
import org.typesense.model.CollectionAliasSchema;
import org.typesense.model.CollectionAliasesResponse;
import org.typesense.model.CollectionResponse;
import org.typesense.model.CollectionSchema;
import org.typesense.model.Field;
import org.typesense.model.SearchOverrideInclude;
import org.typesense.model.SearchOverrideRule;
import org.typesense.model.SearchOverrideSchema;
import org.typesense.model.SearchSynonymSchema;
import org.typesense.resources.Node;

public class Helper {
    private final TypesenseClient client;

    Helper() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node("http", "localhost", "8108"));

        Configuration configuration = new Configuration(nodes, Duration.ofSeconds(3), "xyz");

        this.client = new JerseyClient(configuration);
    }

    public void createTestCollection() throws Exception {
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(new Field().name(".*").type(FieldTypes.AUTO).optional(true));

        CollectionSchema collectionSchema = new CollectionSchema();
        collectionSchema.name("books").fields(fields);

        client.collections().create(collectionSchema);
    }

    public void createTestDocument() throws Exception {
        String[] authors = {"shakspeare", "william"};
        HashMap<String, Object> hmap = new HashMap<>();
        hmap.put("title", "Romeo and juliet");
        hmap.put("authors", authors);
        hmap.put("publication_year", 1666);
        hmap.put("ratings_count", 124);
        hmap.put("average_rating", 3.2);
        hmap.put("id", "1");

        client.collections("books").documents().create(hmap);
    }

    public TypesenseClient getClient() {
        return this.client;
    }

    public void createTestAlias() throws Exception {
        CollectionAliasSchema collectionAliasSchema = new CollectionAliasSchema();
        collectionAliasSchema.collectionName("books_june11");
        client.aliases().upsert("books", collectionAliasSchema);
    }

    public ApiKey createTestKey() throws Exception {
        ApiKeySchema apiKeySchema = new ApiKeySchema();
        List<String> actionValues = new ArrayList<>();
        List<String> collectionValues = new ArrayList<>();
        actionValues.add("*");
        collectionValues.add("*");
        apiKeySchema.description("Admin Key").actions(actionValues).collections(collectionValues);
        return client.keys().create(apiKeySchema);
    }

    public void createTestOverrirde() throws Exception {
        SearchOverrideSchema searchOverrideSchema = new SearchOverrideSchema();
        List<SearchOverrideInclude> searchOverrideIncludes = new ArrayList<>();
        searchOverrideIncludes.add(new SearchOverrideInclude().id("422").position(1));
        searchOverrideSchema.rule(new SearchOverrideRule().query("apple").match(SearchOverrideRule.MatchEnum.EXACT))
                            .includes(searchOverrideIncludes);
        client.collections("books").overrides().upsert("customize-apple", searchOverrideSchema);
    }

    public void createTestSynonym() throws Exception {
        SearchSynonymSchema synonym = new SearchSynonymSchema();
        synonym.addSynonymsItem("blazer").addSynonymsItem("coat").addSynonymsItem("jacket");

        client.collections("books").synonyms().upsert("coat-synonyms", synonym);
    }

    public void teardown() throws Exception {
        CollectionResponse[] collectionResponses = client.collections().retrieve();
        for (CollectionResponse c : collectionResponses) {
            client.collections(c.getName()).delete();
        }

        CollectionAliasesResponse collectionAliasesResponse = client.aliases().retrieve();
        for (CollectionAlias a : collectionAliasesResponse.getAliases()) {
            client.aliases(a.getName()).delete();
        }

        ApiKeysResponse apiKeysResponse = client.keys().retrieve();
        for (ApiKey k : apiKeysResponse.getKeys()) {
            client.keys(k.getId()).delete();
        }
    }
}
