package org.stepic.pinch.s52_9;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(new byte[]{65,13,10,10,13}));
            int a, b = System.in.read();
            if(b == -1) return;
            while ((a = System.in.read()) > 0) {
                if (a != 10 || b != 13) {
                    System.out.write((""+b+" ").getBytes());
                }
                b = a;
            }
            System.out.write((""+b+" ").getBytes());
            System.out.flush();
        }finally {
            System.setIn(stdin);
        }
    }
}
