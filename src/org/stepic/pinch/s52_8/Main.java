package org.stepic.pinch.s52_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})) {
            System.out.println(checkSumOfStream(inputStream));
        }
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int b, sum = 0;
        while((b=inputStream.read())>0){
            sum = Integer.rotateLeft(sum, 1) ^ b;
        }
        return sum;
    }
}
