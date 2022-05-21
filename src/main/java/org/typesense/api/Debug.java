package org.typesense.api;

import java.util.Map;

public class Debug {

    private final ApiCall apiCall;
    public static final String RESOURCEPATH = "/debug";

    public Debug(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public Map<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
