package com.examples.reduceside;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

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

        job.setMapperClass();
        job.setReducerClass(JoinReducer.class);
        job.set
    }
}
