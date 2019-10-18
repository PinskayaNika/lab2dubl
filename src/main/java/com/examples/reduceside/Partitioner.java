package com.examples.reduceside;

import org.apache.hadoop.io.Text;

//Учитывает только код аэропорта
public abstract class Partitioner {
    public 

    public abstract int getPartition (TextPair key, Text value, int numPartitions) {
        int airportID = new Integer(key.getAirportID());
        return  airportID % numPartitions;
    }
}
