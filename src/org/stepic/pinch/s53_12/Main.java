package org.stepic.pinch.s53_12;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        char[] buf = new char[1024];
        int c;
        StringBuilder sb = new StringBuilder();
        try(InputStreamReader reader = new InputStreamReader(inputStream, charset)){
            while((c = reader.read(buf)) >= 0)
                sb.append(new String(buf,0,c));
        }
        return sb.toString();
    }
}
