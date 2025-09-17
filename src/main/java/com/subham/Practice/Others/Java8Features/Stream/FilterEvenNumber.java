package com.subham.Practice.Others.Java8Features.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumber {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(8, 2, 5, 7, 3, 4, 6, 1);  //immutable list - can not add, modify or remove elements - does not allow null values

//        List<Integer> numberList = Arrays.asList(8,2,5,7,3,4,6,1);   //can modify elements but can not add or remove elements - does allow null values

        /*List<Integer> numberLists = new ArrayList<>(List.of(1,5,3,6,9,2));
             What's happening here?
            1. List.of(1, 5, 3, 6, 9, 2)
                    Creates an immutable list with the given elements (Java 9+).
                    So the list it returns cannot be modified (no add, remove, etc.).

            2. new ArrayList<>(...)
                    Creates a new mutable ArrayList, copying the contents of the immutable list.
                    Now you have a modifiable list.*/

        List<Integer> evenNumberList = numberList
                .stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println("before filtering : " + numberList);
        System.out.println("post filtering : " + evenNumberList);

    }
}
