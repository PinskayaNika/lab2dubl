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


    @Override
    public void readFields(DataInput in) throws IOException {
        String stringLine = in.readLine();
        int sizeLine = stringLine.length();
        flag = stringLine.charAt(sizeLine - 1);  //считываем флаг
        airportID = stringLine.substring(0, sizeLine - 1);  //ID
    }

    @Override
    public void write(DataOutput out) throws  IOException {
        out.writeChars(airportID);
        out.writeInt(flag);
    }

    public String getAirportID() {
        return airportID;
    }


    public int getFlag() {
        return flag;
    }


    public int compareToFirstPart(JoinPair other) {
        return airportID.compareTo(other.getAirportID());
    }

    @Override
    public int compareTo(JoinPair other) {
        int cmp = airportID.compareTo(other.getAirportID());  //Сравниваем по строкам ID
        int oterFlag = other.getFlag();
//        if (cmp != 0) {
//            return flag - oterFlag;
//        }
//        return cmp;
        return cmp == 0 ? flag - oterFlag : cmp;

    }

//    @Override
//    public String toString() {
//        return  airportID + "\t" + flag;
//    }



}
