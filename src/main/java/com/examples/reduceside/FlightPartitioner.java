package com.examples.reduceside;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

//Учитывает только код аэропорта
public class FlightPartitioner extends Partitioner<JoinPair, Text> {
    @Override
    public int getPartition (JoinPair key, Text value, int numPartitions) {
     //   int airportID = new Integer(key.getAirportID());
     //   return  airportID % numPartitions;
        return key.getAirportID() % numPartitions;
    }
}
