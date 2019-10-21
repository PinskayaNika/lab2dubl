package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    private static final String EMPTY = "";
    private static final String QUITE = "\"";


    public static String remote(String string) {
        return  string.replaceAll(EMPTY, QUITE);
    }


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        AirportWritable airportWritable = new AirportWritable(value.toString());
        Pair<String, String> airportPair = airportWritable.getAirportPair();

        try {
            context.write(new JoinPair(airportPair.getKey(), 0), new Text(airportPair.getValue()));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}