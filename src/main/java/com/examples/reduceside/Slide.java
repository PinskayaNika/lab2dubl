package com.examples.reduceside;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.io.Text;


public class Slide {
    private final static String FLIGHT_CSV_PATH = "664600583_T_ONTIME_sample.csv";
    private final static String AIRPORT_CSV_PATH = "L_AIRPORT_ID.csv";

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Slide <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(Slide.class);
        job.setJobName("JoinJob.sort");
        MultipleInputs.addInputPath(job, new Path(FLIGHT_CSV_PATH), TextInputFormat.class, CallsJoinMapper.class);
        MultipleInputs.addInputPath(job, new Path(AIRPORT_CSV_PATH), TextInputFormat.class, SystemsJoinMapper.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(TextPair.Partitioner.class);
        job.setGroupingComparatorClass(TextPair.GroupingComparatorClass.class);
        job.setReducerClass(JoinReducer.class);
        job.setMapOutputKeyClass(TextPair.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
