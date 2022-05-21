package org.typesense.api;

import org.typesense.api.exceptions.TypesenseError;
import org.typesense.model.CollectionAlias;
import org.typesense.model.CollectionAliasSchema;
import org.typesense.model.CollectionAliasesResponse;

public class Aliases {

    private final ApiCall apiCall;
    public final static String RESOURCE_PATH = "/aliases";

    public Aliases(ApiCall apiCall){
        this.apiCall = apiCall;
    }


    public CollectionAlias upsert(String name, CollectionAliasSchema collectionAliasSchema) throws Exception {
        return this.apiCall.put(RESOURCE_PATH + '/' + name, collectionAliasSchema, CollectionAlias.class);
    }

    public CollectionAliasesResponse retrieve() throws Exception {
        return this.apiCall.get(RESOURCE_PATH,CollectionAliasesResponse.class);
    }

}
