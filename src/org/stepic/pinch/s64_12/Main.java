package org.stepic.pinch.s64_12;

import java.util.Comparator;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        r.ints().map(x -> x % 100).limit(10).peek(System.out::println).toArray();
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Object[] res = stream.sorted(order).toArray();
        if(res!=null && res.length>0)
            minMaxConsumer.accept((T)res[0], (T)res[res.length-1]);
        else
            minMaxConsumer.accept(null, null);
    }
}
