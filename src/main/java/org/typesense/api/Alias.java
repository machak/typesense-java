package org.typesense.api;

import org.typesense.model.CollectionAlias;

public class Alias {

    public final Call apiCall;
    public final String name;

    public Alias(final Call apiCall, String name) {
        this.apiCall = apiCall;
        this.name = name;
    }

    public CollectionAlias retrieve() throws Exception {
        return this.apiCall.get(this.getEndpoint(), CollectionAlias.class);
    }

    public CollectionAlias delete() throws Exception {
        return this.apiCall.delete(this.getEndpoint(), CollectionAlias.class);
    }

    public String getEndpoint() {
        return Aliases.RESOURCE_PATH + "/" + this.name;
    }
}
