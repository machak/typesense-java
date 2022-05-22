package org.typesense.api;

import java.util.HashMap;
import java.util.Map;

public class Operations {

    private final TypesenseCall apiCall;
    public static final String RESOUCEPATH = "/operations";

    public Operations(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public Map<String, String> perform(String operationName, HashMap<String, String> queryParameters) throws Exception {
        return this.apiCall.post(RESOUCEPATH + '/' + operationName, queryParameters);
    }

    public Map<String, String> perform(String operationName) throws Exception {
        return this.apiCall.post(RESOUCEPATH + '/' + operationName);
    }
}
