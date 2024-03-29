package com.examples.reduceside;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    private static final String EMPTY = "";
    private static final String QUITE = "\"";
    private static final String DELIMITER = "\",";
    private static final int AIRPORT_ID = 0;
    private static final int AIRPORT_NAME = 1;


//    public static String removeQuots(String value) {
//        return  value.replaceAll(QUITE, EMPTY);
//    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      Text airportName;
      int airportId;
        String[] arrColumn = value.toString().split(DELIMITER);
      if (key.get() > 0) {
          airportName = new Text(StringUtils.removeQuots(arrColumn[AIRPORT_NAME]));
          airportId = Integer.parseInt(StringUtils.removeQuots(arrColumn[AIRPORT_ID]));

          JoinPair Key = new JoinPair(airportId, 0);
          context.write(Key, airportName);
      }

    }
}