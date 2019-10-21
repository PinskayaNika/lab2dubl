package com.examples.reduceside;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    private static final String EMPTY = "";
    private static final String QUITE = "\"";
    private static final String DELIMITER = "\",";

    public static String remote(String string) {
        return  string.replaceAll(EMPTY, QUITE);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      Text airportName;
        String[] string = value.toString().split(DELIMITER);
      if (key.get() > 0) {
          airportName = 

      }
    }
}