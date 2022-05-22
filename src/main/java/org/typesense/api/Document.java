package org.typesense.api;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private final TypesenseCall apiCall;
    private final String endpoint;

    Document(String collectionName, String documentId, final TypesenseCall apiCall) {
        this.apiCall = apiCall;

        this.endpoint = Collections.RESOURCE_PATH + '/' + collectionName + Documents.RESOURCE_PATH + '/' + documentId;
    }

    public Map<String, Object> retrieve() throws Exception {
        return this.apiCall.get(endpoint);
    }

    public Map<String, Object> delete() throws Exception {
        return this.apiCall.delete(this.endpoint);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> update(Map<String, Object> document) throws Exception {
        return this.apiCall.patch(this.endpoint, document, HashMap.class);
    }

}
