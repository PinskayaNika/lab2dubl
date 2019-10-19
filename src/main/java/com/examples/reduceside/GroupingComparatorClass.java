package com.examples.reduceside;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//Учитывает только код аэропорта
public class GroupingComparatorClass implements WritableComparator {

    public GroupingComparatorClass() {     //Проверка кода аэропорта
        super(JoinPair.class, true);
    }

    public int compare(WritableComparable a, WritableComparable b) {
        JoinPair Key1 = (JoinPair) a;
        JoinPair Key2 = (JoinPair) b;

        return Key2.compareToFirstPart(Key1);
    }
}

