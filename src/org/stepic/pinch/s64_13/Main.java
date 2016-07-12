package org.stepic.pinch.s64_13;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        Stream<String> st = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines()
                .map(line -> line.split("[\\p{Punct}\\s]+")).flatMap(Arrays::stream).map(String::toLowerCase);
        Map<String, Long> map = (st.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        map.entrySet().stream().sorted((a,b)-> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue()))
                .limit(10).map(Map.Entry::getKey).forEach(System.out::println);

    }
}
