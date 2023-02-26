package com.bext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateFilterListTest {

    public static <T extends Person> List<T> filterPersons( List<T> list, BiPredicate< String, Integer> biPredicate ){
        return list.stream()
                .filter( p -> biPredicate.test( p.getName(), p.getAge()))
                .collect(Collectors.toList());
    }

    public static <T extends Person> List<T> filterPersonsUsingLastNameAge( List<T> list, BiPredicate<String, Integer> biPredicate){
        return list.stream()
                .filter( p -> biPredicate.test( p.getLastname(), p.getAge()))
                .collect(Collectors.toList());
    }

    public static void main(String... args){
        BiPredicate<String, Integer> biPredicateStartAORZero = ( t, u) ->
                t.toUpperCase().startsWith("A") || u == 0;
        BiPredicate<String, Integer> biPredicateContainsA = (t, u) -> t.toUpperCase().contains("A");
        BiPredicate<String, Integer> biPredicateAgeMayor3 = (t, u) -> u > 3;

        List<Person> persons = new ArrayList<>();
        persons.add( new Person("Hugo", "Parra",4) );
        persons.add( new Person( "Paco", "Parra",5));
        persons.add( new Person("Luis", "Parra",5));
        persons.add( new Person( "Ageda", "Rios",7));
        persons.add( new Person( "Bebe", "Rios",0));
        persons.add( new Person( "Baby", "Rios",0));
        persons.add( new Person( "alita", "Rios",3));

        //filter persons start with "A" or age == 0
        List<Person> result = filterPersons( persons, biPredicateStartAORZero);
        System.out.println(result);
        //[Person{name='Ageda', lastname='Rios', age=7}, Person{name='Bebe', lastname='Rios', age=0},
        // Person{name='Baby', lastname='Rios', age=0}, Person{name='alita', lastname='Rios', age=3}]

        // age == 0
        List<Person> result1 = filterPersons( persons, (name, age) -> age == 0);
        System.out.println(result1);
        //[Person{name='Bebe', lastname='Rios', age=0}, Person{name='Baby', lastname='Rios', age=0}]

        // person.name end with "o"
        List<Person> result2 = filterPersons( persons, (name, age) -> name.endsWith("o"));
        System.out.println(result2);
        //[Person{name='Hugo', lastname='Parra', age=4}, Person{name='Paco', lastname='Parra', age=5}]

        // name contains "a" and age > 3
        List<Person> result3 = filterPersons( persons, (name, age) ->
                                                       name.toLowerCase().contains("a") && age > 3
                                             );
        System.out.println(result3);
        //[Person{name='Paco', lastname='Parra', age=5}, Person{name='Ageda', lastname='Rios', age=7}]

        // Chaining with and
        List<Person> result4 = filterPersons( persons, biPredicateContainsA.and(biPredicateAgeMayor3));
        System.out.println( result4);
        //[Person{name='Paco', lastname='Parra', age=5}, Person{name='Ageda', lastname='Rios', age=7}]

        // Chaining with or
        List<Person> result5 = filterPersons( persons, biPredicateAgeMayor3.or((name, age) -> name.equals("Bebe")));
        System.out.println(result5);
        //[Person{name='Hugo', lastname='Parra', age=4}, Person{name='Paco', lastname='Parra', age=5}, Person{name='Luis', lastname='Parra', age=5},
        // Person{name='Ageda', lastname='Rios', age=7}, Person{name='Bebe', lastname='Rios', age=0}]

        List<Person> result6 = filterPersonsUsingLastNameAge( persons, biPredicateContainsA);
        System.out.println(result6);
        //[Person{name='Hugo', lastname='Parra', age=4}, Person{name='Paco', lastname='Parra', age=5}, Person{name='Luis', lastname='Parra', age=5}]

        List<Person> result7 = filterPersonsUsingLastNameAge( persons, biPredicateContainsA.or((lastname, age)-> age == 0));
        System.out.println(result7);
        //[Person{name='Hugo', lastname='Parra', age=4}, Person{name='Paco', lastname='Parra', age=5}, Person{name='Luis', lastname='Parra', age=5},
        // Person{name='Bebe', lastname='Rios', age=0}, Person{name='Baby', lastname='Rios', age=0}]
    }
}

