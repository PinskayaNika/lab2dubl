package com.examples.reduceside;

public class FlightWritable {
    private static FlightWritable ourInstance = new FlightWritable();

    public static FlightWritable getInstance() {
        return ourInstance;
    }

    private FlightWritable() {
    }
}
