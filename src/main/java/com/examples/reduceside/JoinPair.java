package com.examples.reduceside;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class JoinPair implements WritableComparable<JoinPair> {
    public String airportID;
    public int flag;

    public JoinPair() {
        this.airportID = "null";
        this.flag = -1;
    }

    public JoinPair(String airportID, int flag) {
        this.airportID = airportID;
        this.flag = flag;
    }


    //@Override
    public void readFields(DataInput in) throws IOException {
        String stringLine = in.readLine();
        airportID.readFields(in);
        flag.readFields(in);
    }

    //@Override
    public void write(DataOutput out) throws  IOException {
        out.write(airportID);
        out.write(flag);
    }





    public JoinPair(String first, String second) {
        this.airportID = new Text(first);
        this.flag = new Text(second);
    }

    public Text getAirportID() {
        return airportID;
    }

    public void setAirportID(Text airportID) {
        this.airportID = airportID;
    }

    public Text getFlag() {
        return flag;
    }

    public void setFlag(Text flag) {
        this.flag = flag;
    }

    public void set(Text first, Text second) {
        this.airportID = first;
        this.flag = second;
    }

    @Override
    public int hashCode() {
        return airportID.hashCode() * 163 + flag.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JoinPair) {
            JoinPair tp = (JoinPair) obj;
            return airportID.equals(tp.getAirportID()) && flag.equals(tp.getFlag());
        }
        return false;
    }

    @Override
    public String toString() {
        return  airportID + "\t" + flag;
    }


    //@Override
    public int compareToFirstPart(JoinPair other) {
        return airportID.compareTo(other.getAirportID());
    }

    @Override
    public int compareTo(JoinPair tp) {
        int cmp = airportID.compareTo(tp.getAirportID());
        if (cmp != 0) {
            return cmp;
        }
        return flag.compareTo(tp.getFlag());
    }

    public JoinPair reverse() {
        return new JoinPair(flag, airportID);
    }
}
