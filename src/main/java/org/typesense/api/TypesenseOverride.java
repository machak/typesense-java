package org.typesense.api;

import org.typesense.model.SearchOverride;

public class TypesenseOverride {

    private final String collectionName;
    private final String overrideId;
    private final Call apiCall;

    public TypesenseOverride(String collectionName, String overrideId, final Call apiCall) {
        this.collectionName = collectionName;
        this.overrideId = overrideId;
        this.apiCall = apiCall;
    }

    public SearchOverride retrieve() throws Exception {
        return this.apiCall.get(this.getEndpoint(), SearchOverride.class);
    }

    public SearchOverride delete() throws Exception {
        return this.apiCall.delete(this.getEndpoint(), SearchOverride.class);
    }

    public String getEndpoint() {
        return Collections.RESOURCE_PATH + '/' + this.collectionName + '/' + Overrides.RESOURCEPATH + '/' + this.overrideId;
    }
}
