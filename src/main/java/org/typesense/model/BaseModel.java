package org.typesense.model;

import java.util.regex.Pattern;

public class BaseModel {
    private static final Pattern NEW_LINE = Pattern.compile("\n", Pattern.LITERAL);


    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return NEW_LINE.matcher(o.toString()).replaceAll("\n    ");
    }
}
