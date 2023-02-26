package com.bext;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args){
        BiConsumer<Integer, Integer> addTwoNumbers = ( t, u) -> System.out.println(t + u);
        addTwoNumbers.accept( 3, 4);
        // output: 7
    }
}
