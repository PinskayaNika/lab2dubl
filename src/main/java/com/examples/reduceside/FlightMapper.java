package com.examples.reduceside;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Optional;

public class FlightMapper extends Mapper<LongWritable, Text, JoinPair, Text> {
    private final static int AIRPORT_DESTINATION_ID = 14;
    private final static int TOTAL = 18;
    private static final String DELIMITER = ",";


//    private Optional<String> parsePositiveValues(String value) {
//        if (value .isEmpty() || Float.parseFloat(value ) < 0.0f) {
//            return Optional.empty();
//        } else {
//            return Optional.of(value );
//        }
//    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        int airportId;
        String[] arrColumn = value.toString().split(DELIMITER);
        if (key.get() > 0) {
            airportId = Integer.parseInt(arrColumn[AIRPORT_DESTINATION_ID]);
            Optional<String> delay = StringUtils.parsePositiveValues(arrColumn[TOTAL]);

            if (delay.isPresent()) {
                JoinPair Key = new JoinPair(airportId, 1);
                context.write(Key, new Text(delay.get()));
            }

        }
    }
}
