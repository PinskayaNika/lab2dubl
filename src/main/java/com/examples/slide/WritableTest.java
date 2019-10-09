package com.examples.slide;

import java.io.DataInput;
import java.io.DataOutput;

public class WritableTest {
    public interface Writable {
        void readFields(DataInput, in);
        void write (DataOutput, out);
        
    }
}
