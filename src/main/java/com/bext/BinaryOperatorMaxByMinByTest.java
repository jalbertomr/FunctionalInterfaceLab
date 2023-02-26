package com.bext;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorMaxByMinByTest {
    public static void main(String... args){

        Person per1 = new Person("Hugo","Ruiz", 23);
        Person per2 = new Person("Paco","Lopez", 5);
        Person per3 = new Person("Luis","Mendez", 31);
        Person per4 = new Person("Ana","Ramirez", 12);
        Person per5 = new Person("Maria","O", 17);

        List<Person> listPerson = Arrays.asList( per1, per2, per3, per4, per5);

        // Create comparator by age
        Comparator<Person> compareAge = Comparator.comparing(Person::getAge);

        BinaryOperator<Person> binaryOperatorMaxByCompareAge = BinaryOperator.maxBy(compareAge);

        Person person = find(listPerson, binaryOperatorMaxByCompareAge);
        System.out.println(person);
        //Person{name='Luis', lastname='Mendez', age=31}

        System.out.println(
                find( listPerson, BinaryOperator.minBy( Comparator.comparing( Person::getAge)))
        );
        //Person{name='Paco', lastname='Lopez', age=5}

        System.out.println(
                find( listPerson, BinaryOperator.minBy( Comparator.comparing( person1 -> person1.getLastname().length())))
        );
        //Person{name='Maria', lastname='O', age=17}

        System.out.println(
                find( listPerson, BinaryOperator.maxBy( Comparator.comparing( p -> p.getName().length())))
        );
        //Person{name='Maria', lastname='O', age=17}
    }

    public static Person find( List<Person> list, BinaryOperator<Person> accumulate) {
        Person person = null;
        for (Person t : list){
            if (person == null){
                person = t;
            } else {
                person = accumulate.apply( person, t);
            }
        }
        return person;
    }
}
