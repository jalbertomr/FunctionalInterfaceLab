package com.bext;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorTest {
    public static void main(String... args){
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        int sumarrint = accumulatearrint(numbers, 0, (a, b) -> a + b);
        System.out.println(sumarrint); // 55

        int result2 = accumulatearrint(numbers, 0, Integer::sum);
        System.out.println(result2); // 55
    }

    public static  int accumulatearrint(int[] arrint, int init, IntBinaryOperator acumulador){
        int result = init;
        for( int i : arrint){
            result = acumulador.applyAsInt( result, i);
        }
        return result;
    }
}
