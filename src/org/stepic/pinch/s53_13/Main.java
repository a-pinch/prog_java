package org.stepic.pinch.s53_13;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("-1e3\n18 .111 11bbb".getBytes("UTF-8"));
        System.out.printf("%.6f",streamSum(inputStream));
    }

    private static double streamSum(InputStream inputStream) throws IOException {
        double sum = 0;
        String line;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            while((line = reader.readLine()) != null){
                for(String word : line.split("\\s")){
                    try{
                        sum+=Double.parseDouble(word);
                    }catch(NumberFormatException e){}
                }
            }
        }
        return sum;
    }
}
