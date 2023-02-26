package com.bext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class forEachPrintIndex {
    public static void main(String... args){
        String[] names = {"Java", "C++", "Go", "javascript","Node"};

        List<String> list = IntStream.range(0, names.length)
                .mapToObj(idx -> idx + ": " + names[idx])
                .collect(Collectors.toList());
        System.out.println( list);
        //output: [0: Java, 1: C++, 2: Go, 3: javascript, 4: Node]

        /*-- This collect uses biconsumer
        <R> R collect(Supplier<R> supplier,
                BiConsumer<R, ? super T> accumulator,
                BiConsumer<R, R> combiner);
        */
        List<String> listString = Arrays.asList(names);

        HashMap<Integer, String> mapCollected = listString.stream()
                .collect( HashMap<Integer, String>::new,
                        ( map, streamValue) -> map.put(map.size(), streamValue),
                        ( map, map2) -> {} );
        mapCollected.forEach((k,v) -> System.out.println(k + ": " + v));
        /*output:
        0: Java
        1: C++
        2: Go
        3: javascript
        4: Node
         */
    }
}
