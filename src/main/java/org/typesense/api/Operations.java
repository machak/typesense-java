package org.typesense.api;

import java.util.HashMap;

public class Operations {

    private final TypesenseCall apiCall;
    public static final String RESOUCEPATH = "/operations";

    public Operations(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public HashMap<String, String> perform(String operationName, HashMap<String, String> queryParameters) throws Exception {
        return this.apiCall.post(RESOUCEPATH + '/' + operationName, queryParameters);
    }

    public HashMap<String, String> perform(String operationName) throws Exception {
        return this.apiCall.post(RESOUCEPATH + '/' + operationName);
    }
}
