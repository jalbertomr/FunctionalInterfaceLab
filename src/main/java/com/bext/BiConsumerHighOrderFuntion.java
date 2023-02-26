package com.bext;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerHighOrderFuntion {
    public static void main(String... args){

        addTwo( 3, 5, (t, u) -> System.out.println(t + u));           //8
        addTwo( "node",".js", (t, u) -> System.out.println(t + u));   //"node.js"

        math( 2,3, ( a, b) -> System.out.println(a + b));
        math( 2,3, ( a,b ) -> System.out.println(a - b));
        math( 2,3, ( a,b ) -> System.out.println(a / b));
        math(2,3,  ( a,b ) -> System.out.println(a * b));

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"Java");
        map.put(2,"JavaScript");
        map.put(3,"C++");
        map.put(4,"Go");

        map.forEach((k,v) -> System.out.println(k + ": " + map.get(k)));
    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c){
        c.accept(a1, a2);
    }

    @SuppressWarnings("hiding")
	static <Integer> void math(Integer a1, Integer a2, BiConsumer<Integer, Integer> c){
        c.accept(a1, a2);
    }
}
