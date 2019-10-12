package com.examples.reduceside;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair> {
    public Text first;
    public Text second;

    public TextPair() {
        this.first = new Text();
        this.second = new Text();
    }
    


}
