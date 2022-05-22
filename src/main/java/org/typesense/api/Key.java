package org.typesense.api;

import org.typesense.model.ApiKey;

public class Key {

    private final Long id;
    private final TypesenseCall apiCall;

    public Key(Long id, final TypesenseCall apiCall) {
        this.id = id;
        this.apiCall = apiCall;
    }

    public ApiKey retrieve() throws Exception {
        return this.apiCall.get(this.getEndpoint(), ApiKey.class);
    }

    public ApiKey delete() throws Exception {
        return this.apiCall.delete(this.getEndpoint(), ApiKey.class);
    }

    private String getEndpoint() {
        return Keys.RESOURCEPATH + '/' + this.id;
    }
}
