package com.examples.reduceside;
//
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
//import org.apache.hadoop.mapreduce.Job;
//
//import org.apache.hadoop.io.Text;
//
//
//public class Slide {
//    private final static String FLIGHT_CSV_PATH = "664600583_T_ONTIME_sample.csv";
//    private final static String AIRPORT_CSV_PATH = "L_AIRPORT_ID.csv";
//    //public final static String DELIMITER = ",";
//
//    public static void main(String[] args) throws Exception {
//        if (args.length != 3) {
//            System.err.println("Usage: Slide <output path>");
//            System.exit(-1);
//        }
//        Job job = Job.getInstance();
//        job.setJarByClass(Slide.class);
//        job.setJobName("JoinJob.sort");
//        //MultipleInputs.addInputPath(job, new Path(FLIGHT_CSV_PATH), TextInputFormat.class, FlightMapper.class);
//        //MultipleInputs.addInputPath(job, new Path(AIRPORT_CSV_PATH), TextInputFormat.class, AirportMapper.class);
//
//
//        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
//        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
//
//
//
//        FileOutputFormat.setOutputPath(job, new Path(args[2]));
//
//        job.setReducerClass(JoinReducer.class);
//        job.setPartitionerClass(FlightPartitioner.class);
//        job.setGroupingComparatorClass(GroupingComparatorClass.class);
//
//        job.setMapOutputKeyClass(JoinPair.class); //Для двойного ключа
//        job.setMapOutputValueClass(Text.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//        job.setNumReduceTasks(2);
//        System.exit(job.waitForCompletion(true) ? 0 : 1);
//    }
//}
//

//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
//import org.apache.hadoop.mapreduce.Job;
//
//import org.apache.hadoop.io.Text;
//
//public class SlideJoin {
//    private final static String FLIGHT_CSV_PATH = "664600583_T_ONTIME_sample.csv";
//    private final static String AIRPORT_CSV_PATH = "L_AIRPORT_ID.csv";
//    //public final static String DELIMITER = ",";
//
//    public static void main(String[] args) throws Exception {
//        if (args.length != 3) {
//            System.err.println("Usage: Slide <output path>");
//            System.exit(-1);
//        }
//        Job job = Job.getInstance();
//        job.setJarByClass(SlideJoin.class);
//        job.setJobName("JoinJob.sort");
//        //MultipleInputs.addInputPath(job, new Path(FLIGHT_CSV_PATH), TextInputFormat.class, FlightMapper.class);
//        //MultipleInputs.addInputPath(job, new Path(AIRPORT_CSV_PATH), TextInputFormat.class, AirportMapper.class);
//
//
//        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
//        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
//
//
//
//        FileOutputFormat.setOutputPath(job, new Path(args[2]));
//
//        job.setReducerClass(JoinReducer.class);
//        job.setPartitionerClass(FlightPartitioner.class);
//        job.setGroupingComparatorClass(GroupingComparatorClass.class);
//
//        job.setMapOutputKeyClass(JoinPair.class); //Для двойного ключа
//        job.setMapOutputValueClass(Text.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//        job.setNumReduceTasks(2);
//        System.exit(job.waitForCompletion(true) ? 0 : 1);
//    }
//}
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.io.Text;


public class Slide {
    private final static String FLIGHT_CSV_PATH = "664600583_T_ONTIME_sample.csv";
    private final static String AIRPORT_CSV_PATH = "L_AIRPORT_ID.csv";
    //public final static String DELIMITER = ",";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: Slide <output path>");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(Slide.class);
        job.setJobName("JoinJob sort");
        //MultipleInputs.addInputPath(job, new Path(FLIGHT_CSV_PATH), TextInputFormat.class, FlightMapper.class);
        //MultipleInputs.addInputPath(job, new Path(AIRPORT_CSV_PATH), TextInputFormat.class, AirportMapper.class);


        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setReducerClass(JoinReducer.class);
        job.setPartitionerClass(FlightPartitioner.class);
        job.setGroupingComparatorClass(GroupingComparatorClass.class);

        job.setMapOutputKeyClass(JoinPair.class); //Для двойного ключа
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}