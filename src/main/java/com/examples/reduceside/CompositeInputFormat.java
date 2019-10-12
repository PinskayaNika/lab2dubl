package com.examples.slide;



public class CompositeInputFormat {
    CompositeInputFormat.compose("inner",
            KeyValueTextInputFormat.class,
            file1,
            file2
    );
}
