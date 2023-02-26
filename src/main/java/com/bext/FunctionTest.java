package com.bext;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Uso de Function
 * 
 * @author bext
 *
 */
public class FunctionTest {
    public static void main(String... args){
    	/**
    	 *  Definiciones de Functions
    	 */
        Function<Integer, Integer> functionAdd3 = (t) -> t + 3;
        Function<Integer, Integer> functionMultiply2 = (t) -> t * 2;
        /** 
         * Function.compose to add more Functions to Function.
         */
        Function<Integer, Integer> functionMultiplyThenAdd = functionMultiply2.compose( functionAdd3);
        /**
         * Function.identity to return the input value. not necesary just call the static.
         */
        Function<Integer,Integer> functionIdentity = Function.identity();
        
        System.out.println( functionAdd3.apply(2)      );   //output: 5
        System.out.println( functionMultiply2.apply(4));  //output: 8
        System.out.println(
                functionAdd3.andThen( functionMultiply2).apply( 3)  //output: 12
        );
        System.out.println(
                functionAdd3.andThen( functionAdd3)
                    .andThen( functionAdd3).apply( 1)    //output: 10
        );

        System.out.println(
                functionAdd3.andThen( functionAdd3)
                        .andThen( functionAdd3)
                        .andThen( functionMultiply2)
                        .apply( 1)    //output: 20
        );

        System.out.println( functionMultiplyThenAdd.apply( 4));  // (4 + 3) * 2 = 14

        System.out.println( functionIdentity.apply(111)); // 111
        
        List<String> names = Arrays.asList("Hugo", "Paco", "Luis", "Daisy");

        names.stream()
        .map(e -> e)
        .forEach(System.out::println);
        
        names.stream()
        .map(Function.identity())
        .map(e -> e.concat(" "))
        .forEach(System.out::println);;
        
        System.out.println();
        
        Function<Integer, String> functionInt_String = t -> t * 2 + "_doubled.";
        Function<String, Integer> functionString_Int = t -> t.length();

        System.out.println( functionInt_String.apply( 7));      //output: 14_doubled
        System.out.println( functionString_Int.apply("palabra")); //output: 7

        System.out.println(
        functionInt_String.andThen( functionString_Int ).apply( 7) // output: 11
        );

        System.out.println(
                functionInt_String.andThen( functionString_Int)
                .andThen( functionInt_String)
                .apply( 3)                                   // output: 20_doubles
        );


    }
}
