package com.examples.reduceside;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;


public class JoinReducer extends Reducer<TextPair, Text, Text, Text>  {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int counter = 0;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        Double currentDelay, sum = 0.0;

        Iterator<Text> iter = values.iterator();
        Text systemInfo = new Text(iter.next());
        while (iter.hasNext()) {
            Text call = iter.next();

            //Change
            Text outValue = new Text(call.toString() + "\t" + systemInfo.toString());
            context.write(key.getFirst(), outValue);


        }
    }


}
