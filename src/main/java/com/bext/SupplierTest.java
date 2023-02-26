package com.bext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String... args){
        Supplier<Double> generateRandom = () -> Math.random();
        Supplier<List<Double>> generateRandoms = () -> {
            List<Double> listdouble =  new ArrayList<Double>();
            for (int i = 0; i < 10; i++) {
                listdouble.add( Math.random());
            }
            return listdouble;
        };

        System.out.println( generateRandom.get());
        System.out.println( generateRandoms.get());
    }
}
