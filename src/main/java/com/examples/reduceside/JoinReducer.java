package com.examples.reduceside;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;


public class JoinReducer extends Reducer<TextPair, Text, Text, Text>  {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text
    }


}
