package com.examples.reduceside;

import java.util.Optional;

public class ParseRemove {
    private static final String EMPTY = "";
    private static final String QUITE = "\"";

    public static Optional<String> parsePositiveValues(String value) {
        if (value .isEmpty() || Float.parseFloat(value ) < 0.0f) {
            return Optional.empty();
        } else {
            return Optional.of(value );
        }
    }
    public static String remove(String value) {
        return  value.replaceAll(QUITE, EMPTY);
    }

}
