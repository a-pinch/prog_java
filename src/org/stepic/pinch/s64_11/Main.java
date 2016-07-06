package org.stepic.pinch.s64_11;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> {int y = x*x; return y / 10 % 10 + 10 * (y / 100 % 10) + 100 * (y / 1000 % 10);});
    }
}
