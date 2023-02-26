package com.bext;

import java.util.function.Predicate;

/*
   Functional Interfaces 4 Types
                input      output
   Predicate :   ---        boolean
   Consumer  :   ---        ---        mutate data
   Function  : T class ,   V class
   Supply    :   ---
 */
public class PredicateTest {
    public static void main(String... args){
        Predicate<String> strHasElements = t -> t.length() > 0;
        Predicate<String> strLessthan10 = t -> t.length() < 10;
        Predicate<String> strGreatherthan10 = t -> t.length() > 10;
        Predicate<String> strhasElementsAndLess10 = strHasElements.and( strLessthan10);

        System.out.println( strHasElements.test(""));        // output: false
        System.out.println( strHasElements.test( " "));      // output: true
        System.out.println( strHasElements.test( "algo"));   // output: true
        System.out.println( strhasElementsAndLess10.test( "ks"));              // true
        System.out.println( strhasElementsAndLess10.test( "1234567891234"));   // false
        // Negate
        System.out.println( strHasElements.negate().test("")); // output: true

        // Chaining
        System.out.println( strHasElements.and( strLessthan10 )
                                          .test("") );    //output false
        System.out.println( strHasElements.and( strLessthan10 )
                                          .test("algo")); //output true
        System.out.println( strHasElements.and( strLessthan10)
                                          .test( "stringtolarge")); //output false
        System.out.println( strHasElements.or( strLessthan10)
                                          .test( "12345678910"));  //output true
        System.out.println( strHasElements.or( strLessthan10)
                                          .test( ""));             //output true
        System.out.println( strHasElements.or( strGreatherthan10)
                                          .test( ""));             //output false


    }
}
