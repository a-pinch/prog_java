package org.stepic.pinch.s62_15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new ByteArrayInputStream("1 2 3 4 5 6 7".getBytes(StandardCharsets.UTF_8)));
//            Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int i=0;
        Integer next;
        while (scanner.hasNext()){
            next = scanner.nextInt();
            if(i++ % 2 != 0)
                deque.add(next);
        }
        for(Iterator<Integer> itr = deque.descendingIterator();itr.hasNext();){
            System.out.print(itr.next()+" ");
        }
    }
}
