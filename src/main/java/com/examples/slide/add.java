package com.examples.slide;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//public class WritableTest {
    public interface Writable {
        void readFields(DataInput, in);
        void write (DataOutput, out);
    }
    public class add implements Writable {
        public int a;
        public int b;
        public add() {
            this.a = a;
            this.b = b;
        }

        public void write(DataOutput out) throws IOException {
            out.writeInt(a);
            out.writeInt(b);
        }

        public void readFields(DataInput in) throws IOException {
            a = in.readInt();
            b = in.readInt();
        }

        public String toString () {
            return Integer.toString(a) + ", " + Integer.toString(b);
        }
    }
//}
