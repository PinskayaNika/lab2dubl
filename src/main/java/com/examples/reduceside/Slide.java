package com.examples.reduceside;
import org.apache.hadoop.mapreduce.Job;

public class Slide {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Slide <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(JoinJob sort)
    }
}
