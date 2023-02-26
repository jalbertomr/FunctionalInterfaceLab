package com.bext;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String... args){
        BiPredicate<String,Integer> checkLength = (t,u) -> t.length() == u;

        System.out.println( checkLength.test("hola", 4)); // true
        System.out.println( checkLength.test( "123456", 5));  // false
    }
}
