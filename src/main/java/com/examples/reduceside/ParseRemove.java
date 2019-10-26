package com.examples.reduceside;

import java.util.Optional;

public class ParseRemove {
    public Optional<String> parsePositiveValues(String value) {
        if (value .isEmpty() || Float.parseFloat(value ) < 0.0f) {
            return Optional.empty();
        } else {
            return Optional.of(value );
        }
    }

}
