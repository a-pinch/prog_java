package org.stepic.pinch.s62_14;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        System.out.println(symmetricDifference(set1,set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<T>();
        for(T v1:set1){
            if(!set2.contains(v1))
                resultSet.add(v1);
        }
        for(T v2:set2){
            if(!set1.contains(v2))
                resultSet.add(v2);
        }
        return resultSet;
    }
}
