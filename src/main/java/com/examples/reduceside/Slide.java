package com.examples.reduceside;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.io.Text;


public class Slide {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Slide <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(Slide.class);
        job.setJobName("JoinJob.sort");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, CallsJoinMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, SystemsJoinMapper.class);


        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(TextPair.FirstPartitioner.class);
        job.setGroupingComparatorClass(TextPair.FirstComparator.class);
        job.setReducerClass(JoinReducer.class);
        job.setMapOutputKeyClass(TextPair.class);

        job.setOutputKeyClass(Text.class);
    }
}
