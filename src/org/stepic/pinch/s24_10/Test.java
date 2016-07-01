package org.stepic.pinch.s24_10;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Test{
    public static void main(String[] args) throws Exception{
        File f = new File("./org/stepic/pinch/s24_10/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String l = null;
        ArrayList<String> roles = new ArrayList<String>();
        ArrayList<String> text = new ArrayList<String>();
        boolean r = false, t = false;
        while((l = br.readLine()) != null) {
            if(l.startsWith("roles:")){
                r = true;
                t = false;
                continue;
            }
            if(l.startsWith("textLines:")){
                r = false;
                t = true;
                continue;
            }
            if(r){
                roles.add(l);
            }else if(t){
                text.add(l);
            }
        }

        System.out.println(printTextPerRole(roles.toArray(new String[0]), text.toArray(new String[0])));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] rt = new StringBuilder[roles.length];
        Arrays.setAll(rt, i->new StringBuilder());
        int k=1;
        for(int i=0;i<textLines.length;++i){
            String[] tmp = textLines[i].split(":",2);
            for(int j=0; j<roles.length; ++j){
                if(roles[j].equals(tmp[0])){
                    rt[j].append(k+")").append(tmp[1]).append("\n");
                    k++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<roles.length; ++i) {
            if(rt[i].length()>0) {
                sb.append(roles[i]).append(":\n").append(rt[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }
}