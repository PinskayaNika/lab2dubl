package com.examples.reduceside;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//Учитывает только код аэропорта
//public class GroupingComparatorClass extends WritableComparator {
//
//    protected GroupingComparatorClass() {     //Проверка кода аэропорта
//        super(JoinPair.class, true);
//    }
//
//    @Override
//    public int compare(WritableComparable a, WritableComparable b) {
//        JoinPair Key1 = (JoinPair) a;
//        JoinPair Key2 = (JoinPair) b;
//
//        return Key1.compareToFirstPart(Key2);
//    }
//}

public class GroupingComparatorClass extends WritableComparator {
    protected GroupingComparatorClass(){
        super(JoinPair.class, true);
    }

    public int compare(WritableComparable first, WritableComparable second){
        JoinPair f =(JoinPair) first;
        JoinPair s =(JoinPair) second;
        return f.compareToFirstPart(s);
    }
}