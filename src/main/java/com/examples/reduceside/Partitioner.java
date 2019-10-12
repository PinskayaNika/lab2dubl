package com.examples.reduceside;

//Учитывает только код аэропорта
public abstract class Partitioner {
    public abstract int getPartition (KEY key, VALUE value, int numPartitions)
}
