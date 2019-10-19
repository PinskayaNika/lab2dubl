package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FlightWritable flightWritable = new FlightWritable(value.toString());
        Pair<String, String> flightPair = flightWritable.getFlightPair();
        try {
            context.write(new JoinPair(flightPair.getKey(), "1"),
                    new Text(flightPair.getValue()));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
