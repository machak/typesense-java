package org.typesense.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.typesense.Const;
import org.typesense.model.DeleteDocumentsParameters;
import org.typesense.model.ExportDocumentsParameters;
import org.typesense.model.ImportDocumentsParameters;
import org.typesense.model.SearchParameters;
import org.typesense.model.SearchResult;

public class Documents {

    private static final Logger log = LoggerFactory.getLogger(Documents.class);
    private final String collectionName;
    private final TypesenseCall apiCall;
    public static final String RESOURCE_PATH = "/documents";

    public Documents(String collectionName, final TypesenseCall apiCall, Configuration configuration) {
        this.collectionName = collectionName;
        this.apiCall = apiCall;
    }

    public Map<String, Object> create(Map<String, Object> document) throws Exception {
        return this.apiCall.post(getEndPoint("/"), document);
    }

    public String create(String document) throws Exception {
        return this.apiCall.post(getEndPoint("/"), document, null, String.class);
    }

    public String create(HashMap<String, Object> document, ImportDocumentsParameters queryParameters) throws Exception {
        return this.apiCall.post(getEndPoint("/"), document, queryParameters, String.class);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> upsert(HashMap<String, Object> document) throws Exception {
        ImportDocumentsParameters queryParameters = new ImportDocumentsParameters();
        queryParameters.action("upsert");

        return this.apiCall.post(getEndPoint("/"), document, queryParameters, HashMap.class);
    }

    public SearchResult search(SearchParameters searchParameters) throws Exception {
        return this.apiCall.get(getEndPoint("search"), searchParameters, org.typesense.model.SearchResult.class);
    }

    public Map<String, Object> delete(DeleteDocumentsParameters queryParameters) throws Exception {
        return this.apiCall.delete(getEndPoint("/"), queryParameters);
    }

    public String export() throws Exception {
        return this.apiCall.get(getEndPoint("export"), String.class);
    }

    public String export(ExportDocumentsParameters exportDocumentsParameters) throws Exception {
        return this.apiCall.get(getEndPoint("export"), exportDocumentsParameters, String.class);
    }

    public String import_(String document, ImportDocumentsParameters queryParameters) throws Exception {
        return this.apiCall.post(this.getEndPoint("import"), document, queryParameters, String.class);
    }

    public String import_(List<Map<String, Object>> documents, ImportDocumentsParameters queryParameters) throws Exception {

        String json = "";
        for (Map<String, Object> document : documents) {
            try {
                //Convert Map to JSON
                json = json.concat(Const.MAPPER.writeValueAsString(document) + '\n');
            } catch (Exception e) {
                log.error("Error importing:", e);
            }
        }
        json = json.trim();
        return this.apiCall.post(this.getEndPoint("import"), json, queryParameters, String.class);
    }

    public String getEndPoint(String target) {
        return Collections.RESOURCE_PATH + '/' + this.collectionName + Documents.RESOURCE_PATH + '/' + target;
    }
}
