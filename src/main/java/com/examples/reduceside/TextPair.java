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

    public TextPair(Text first, Text second) {
        this.first = first;
        this.second = second;
    }

    public TextPair(String first, String second) {
        this.first = new Text(first);
        this.second = new Text(second);
    }

    public Text getFirst() {
        return first;
    }

    public void setFirst(Text first) {
        this.first = first;
    }

    public Text getSecond() {
        return second;
    }

    public void setSecond(Text second) {
        this.second = second;
    }

    
}
