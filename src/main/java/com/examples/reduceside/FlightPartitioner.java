package com.examples.reduceside;

import org.apache.hadoop.io.Text;

//Учитывает только код аэропорта
public abstract class Partitioner {
    public Partitioner() {

    }

    public abstract int getPartition (JoinPair key, Text value, int numPartitions) {
        int airportID = new Integer(key.getAirportID());
        return  airportID % numPartitions;
    }
}