package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Text airportName;
        int airportId;
        String[] string = value.toString().split(DELIMITER);
        if (key.get() > 0) {
            airportName = new Text(remote(string[AIRPORT_NAME]));
            airportId = Integer.parseInt(remote(string[AIRPORT_ID]));

            JoinPair Key = new JoinPair(airportId, 0);
            context.write(Key, airportName);
        }

    }
}
