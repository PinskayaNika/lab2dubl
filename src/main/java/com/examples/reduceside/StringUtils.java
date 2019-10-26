package com.examples.reduceside;

import java.util.Optional;

class StringUtils {
    private static final String EMPTY = "";
    private static final String QUITE = "\"";

    static Optional<String> parsePositiveValues(String value) {
        if (value .isEmpty() || Float.parseFloat(value ) < 0.0f) {
            return Optional.empty();
        } else {
            return Optional.of(value );
        }
    }
    static String removeQuots(String value) {
        return  value.replaceAll(QUITE, EMPTY);
    }

}
