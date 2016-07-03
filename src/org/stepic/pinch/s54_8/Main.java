package org.stepic.pinch.s54_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] res;
        try(ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data))){
            int num = inputStream.readInt();
            res = new Animal[num];
            for(int i=0;i<num;i++){
                res[i]=(Animal) inputStream.readObject();
            }
        }catch (Exception ex){
            throw new IllegalArgumentException(ex);
        }
        return res;
    }
}
