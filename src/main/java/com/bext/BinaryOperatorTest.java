package com.bext;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args){

        BiFunction<Integer, Integer, Integer> func = (a, b) -> a + b;

        Integer result = func.apply(12, 8);
        System.out.println( result);

        // BinaryOperator As accept the same type
        BinaryOperator<Integer> func2 = (a, b) -> a + b;
        Integer result2 = func2.apply(12, 8);
        System.out.println(result2);

        //BinaryOperator as argument

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer result3 = accumulateList(Arrays.asList(numbers), 0, Integer::sum);
        System.out.println( result3); // 55

        Integer result4 = accumulateList(Arrays.asList(numbers), 0, (a, b) -> a - b);
        System.out.println( result4); // -55

        Integer result5 = accumulateList(Arrays.asList(numbers), 0, (a, b) -> b - a);
        System.out.println( result5); // 5

        List<String> stringList = Arrays.asList("esto", "es", "una", "suma", "de", "strings");
        String sumStringlist = accumulateList(stringList, "", String::concat);
        System.out.println( sumStringlist); // "estoesunasumadestrings"

        BinaryOperator<String> binopaddString = (a, b) -> a + b;
        String sumStringlist2 = accumulateList(stringList, "", binopaddString);
        System.out.println(sumStringlist2); // "estoesunasumadestrings"

        BinaryOperator<String> binopaddStringSpace = (a, b) -> a + b + " ";
        String sumStringlist3 = accumulateList(stringList, "", binopaddStringSpace);
        System.out.println(sumStringlist3); // "esto es una suma de strings "

        String sumStringlist4 = accumulateList(stringList, "", (a, b) -> a + b + "_");
        System.out.println(sumStringlist4); // esto_es_una_suma_de_strings_

    }

    public static <T> T accumulateList(List<T> list, T init, BinaryOperator<T> acumulador){
        T result = init;
        for (T t: list){
            result = acumulador.apply( result, t);
        }
        return result;
    }
}
