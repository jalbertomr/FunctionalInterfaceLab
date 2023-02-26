package com.bext;

import java.util.function.Consumer;



public class ConsumerTest {

    public static void main(String... args){
        Consumer<Person> modifyName = t -> t.setName( "name mutated");
        Consumer<String> printConsumer = t -> System.out.println(t);

        Person person = new Person();
        modifyName.accept( person);
        System.out.println( person.getName());

        String stringVar = "this is a string";
        printConsumer.accept( stringVar);
        printConsumer.andThen( printConsumer ).accept( stringVar );

        printConsumer.accept("consumer is consuming this");

        // Generic Consumer
        /*
        Consumer genericConsumer = new Consumer<>(){
            @Override
            public void accept(Object o) {
               System.out.println(o);
            }
        };
        */

    }
}
