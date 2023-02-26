package com.bext;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerHighOrderFunction {
    public static void main(String... args){

        List<Integer> listInteger = Arrays.asList(1,2,3,4,5);
        List<String> listString = Arrays.asList("Hugo","Paco","Luis");

        Consumer<Integer> consumerInteger = (Integer e) -> System.out.println(e);
        Consumer<String> consumerString = (String e) -> System.out.println(e);

        procEach( listInteger, consumerInteger);
        procEach( listString, consumerString);
    }

    static <T> void procEach(List<T> list, Consumer<T> consumer){
        for ( T t : list){
            consumer.accept(t);
        }
    }
}
