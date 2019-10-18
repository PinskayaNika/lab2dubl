package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CallsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FlightWritable flightWritable = new flightWritable(value.toString());
        Pair<String, String> flightPair = flightWritable.getFlightPair();
        context.write(new TextPair(flightWritable.getSystemA().toString(), "1"),
                new Text(flightWritable.toString()));
    }
}
