package org.typesense.model;

import org.typesense.api.SearchOverride;
import org.typesense.api.SearchOverrideSchema;
import org.typesense.api.SearchOverridesResponse;

public class Overrides {

    public static String RESOURCEPATH = "/overrides";

    private String collectionName;
    private ApiCall apiCall;

    public Overrides(String collectionName, ApiCall apiCall) {
        this.collectionName = collectionName;
        this.apiCall = apiCall;
    }

    public SearchOverride upsert(String overrideId, SearchOverrideSchema searchOverrideSchema){
        return this.apiCall.put(getEndpoint(overrideId), searchOverrideSchema, SearchOverride.class);
    }

    public SearchOverridesResponse retrieve(){
        return this.apiCall.get(this.getEndpoint(null), SearchOverridesResponse.class);
    }

    public String getEndpoint(String operation){
        return Collections.RESOURCE_PATH + "/" + this.collectionName + Overrides.RESOURCEPATH + "/" + (operation==null? "":operation);
    }
}
