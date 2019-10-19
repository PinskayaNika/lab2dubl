package com.examples.reduceside;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;


public class JoinReducer extends Reducer<JoinPair, Text, Text, Text>  {
    @Override
    protected void reduce(JoinPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int counter = 0;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        Double currentDelay, sum = 0.0;

        Iterator iterator = values.iterator();
        String airportName = iterator.next().toString();

        while (iterator.hasNext()) {
            String call = iterator.next().toString();

            if (call.length() == 0) {
                continue;
            }

            currentDelay = new Double(call);
            if (currentDelay == 0.0) {
                continue;
            }
            //Change
            Text outValue = new Text(call.toString() + "\t" + systemInfo.toString());
            context.write(key.getAirportID(), outValue);


        }
    }


}
