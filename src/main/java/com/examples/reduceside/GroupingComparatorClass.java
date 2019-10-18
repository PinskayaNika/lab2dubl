package com.examples.reduceside;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;

//Учитывает только код аэропорта
public class GroupingComparatorClass implements RawComparator {
    public int compare(WritableComparable a, WritableComparable b) {
        return a.compareTo(b);
    }
}

