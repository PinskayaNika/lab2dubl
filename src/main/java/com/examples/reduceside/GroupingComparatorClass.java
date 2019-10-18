package com.examples.reduceside;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//Учитывает только код аэропорта
public class GroupingComparatorClass implements WritableComparator {
    public FlightComparator() {     //Проверка кода аэропорта
        super(TextPair.class, true);
    }
    
    public int compare(WritableComparable a, WritableComparable b) {
        TextPair Key1 = (TextPair) a;
        TextPair Key2 = (TextPair) b;

        return Key2.compareToFirstPart(Key1);
    }
}

