package org.stepic.pinch.s52_9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            int a, b = System.in.read();
            if(b == -1) return;
            while ((a = System.in.read()) > 0) {
                if (a != 10 || b != 13) {
                    System.out.write(b & 0xFF);
                }
                b = a;
            }
            System.out.write(b & 0xFF);
            System.out.flush();
    }
}
