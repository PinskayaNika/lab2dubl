package com.examples.reduceside;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;


public class JoinReducer extends Reducer<JoinPair, Text, Text, Text>  {
    @Override
    protected void reduce(JoinPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        /*int counter = 0;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        Double currentDelay, sum = 0.0;
*/
        Iterator iterator = values.iterator();
        String airportName = iterator.next().toString();

        if (iterator.hasNext()) {
            int counter = 0;
            Double min = Double.MAX_VALUE;
            Double max = Double.MIN_VALUE;
            Double currentDelay, sum = 0.0;
            while (iterator.hasNext()) {
                String call = iterator.next().toString();

                if (call.length() == 0) {
                    continue;
                }

                currentDelay = new Double(call);

                if (currentDelay == 0.0) {
                    continue;
                }

                if (counter == 0 || max < currentDelay) {
                    max = currentDelay;
                }

                if (counter == 0 || min > currentDelay) {
                    min = currentDelay;
                }

                sum = sum + currentDelay;
                counter = counter + 1;
            }

                String outValue = "".concat("[Min: ".concat(min.toString().concat(", ")));
                outValue = outValue.concat("Max: ").concat(max.toString()).concat(", ");
                outValue = outValue.concat("Avg: ").concat(new Double(Math.round(10.0 * (sum / counter)) / 10.0).toString().concat("];"));
                context.write(new Text(airportName), new Text(outValue));
        }

    }
}
