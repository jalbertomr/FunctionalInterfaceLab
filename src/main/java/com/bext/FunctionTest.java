package com.bext;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String... args){
        Function<Integer, Integer> add3 = (t) -> t + 3;
        Function<Integer, Integer> multiply2 = (t) -> t * 2;
        Function<Integer, Integer> multiplyThenAdd = multiply2.compose( add3);

        System.out.println( add3.apply(2)      );   //output: 5
        System.out.println( multiply2.apply(4));  //output: 8
        System.out.println(
                add3.andThen( multiply2).apply( 3)  //output: 12
        );
        System.out.println(
                add3.andThen( add3)
                    .andThen( add3).apply( 1)    //output: 10
        );

        System.out.println(
                add3.andThen( add3)
                        .andThen( add3)
                        .andThen( multiply2)
                        .apply( 1)    //output: 20
        );

        System.out.println( multiplyThenAdd.apply( 4));  // (4 + 3) * 2 = 14

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
