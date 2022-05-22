package org.typesense.api;

import org.typesense.model.SearchSynonym;

public class Synonym {

    private final String collectionName;
    private final String synonymId;
    private final TypesenseCall apiCall;

    public Synonym(String collectionName, String synonymId, final TypesenseCall apiCall) {
        this.collectionName = collectionName;
        this.synonymId = synonymId;
        this.apiCall = apiCall;
    }

    public SearchSynonym retrieve() throws Exception {
        return this.apiCall.get(this.getEndpoint(), SearchSynonym.class);
    }

    public SearchSynonym delete() throws Exception {
        return this.apiCall.delete(this.getEndpoint(), SearchSynonym.class);
    }

    public String getEndpoint() {
        return Collections.RESOURCE_PATH + '/' + this.collectionName + Synonyms.RESOURCEPATH + '/' + this.synonymId;
    }
}
