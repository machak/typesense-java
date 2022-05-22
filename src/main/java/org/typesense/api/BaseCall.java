package org.typesense.api;

import java.util.ArrayList;
import java.util.Map;

public abstract class BaseCall implements TypesenseCall {


    protected void extractParameters(final Map.Entry<String, Object> entry, final StringBuilder value) {
        for (int i = 0; i < ((ArrayList<?>) entry.getValue()).size(); i++) {
            value.append(((ArrayList<?>) entry.getValue()).get(i));
            if (i != ((ArrayList<?>) entry.getValue()).size() - 1) {
                value.append(',');
            }
        }
    }
}
