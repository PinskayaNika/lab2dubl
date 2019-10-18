package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SystemsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Writable airportWritable = new Writable(value.toString());
        Pair<String, String> airportPair = Writable.getAiroportPair();
        try {
            context.write(new TextPair(airportPair.getKey(), "0"), new Text(airportPair.getValue()));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}