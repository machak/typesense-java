package org.typesense.api;

import java.util.HashMap;
import java.util.List;

import org.typesense.model.MultiSearchResponse;

public class MultiSearch {

    private final ApiCall apiCall;
    public static final String RESOURCEPATH = "/multi_search";

    public MultiSearch(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public MultiSearchResponse perform(HashMap<String, List<HashMap<String, String>>> multiSearchParameters, HashMap<String, String> common_params) throws Exception {
        return this.apiCall.post(MultiSearch.RESOURCEPATH, multiSearchParameters, common_params, MultiSearchResponse.class);
    }
}
