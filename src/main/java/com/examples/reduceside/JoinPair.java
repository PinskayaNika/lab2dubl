package com.examples.reduceside;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class JoinPair implements WritableComparable {
    public int airportID;
    public int flag;

    public JoinPair(int airportID, int flag) {
        this.airportID = airportID;
        this.flag = flag;
    }

    public JoinPair(){}

    @Override
    public void readFields(DataInput in) throws IOException {
        airportID = in.readInt();  //ID
        flag = in.readInt(); //считываем флаг

    }

    @Override
    public void write(DataOutput out) throws  IOException {
        out.writeInt(airportID);
        out.writeInt(flag);
    }

    public int getAirportID() {
        return airportID;
    }


    public int getFlag() {
        return flag;
    }


    public int compareToFirstPart(JoinPair other) {
        JoinPair second = other;
        if (this.airportID > second.airportID) {
            return 1;
        } else  if (this.airportID < second.airportID) {
            return -1;
        }
        return 0;
    }

    //@Override
    public int compareTo(Object other) {
        JoinPair a = (JoinPair) other;
        if (this.airportID > a.airportID) {
            return 1;
        } else  if (this.airportID < a.airportID) {
            return -1;
        }
        if (this.flag > a.flag) {
            return 1;
        } else  if (this.flag < a.flag) {
            return -1;
        }
        return 0;
    }

   //    @Override
//    public String toString() {
//        return  airportID + "\t" + flag;
//    }



}
