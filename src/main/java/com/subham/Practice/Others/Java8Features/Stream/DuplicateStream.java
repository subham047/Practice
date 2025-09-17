package com.subham.Practice.Others.Java8Features.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 8, 9, 6, 5, 8, 7);

        // find duplicates
        Set<Integer> intSet = new HashSet<>();

        Set<Integer> duplicateSet = list.stream().collect(Collectors.groupingBy(intVal -> intVal, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getValue() > 1)
                .map(entrySet -> entrySet.getKey())
                .collect(Collectors.toSet());
        System.out.println("duplicate list = "+duplicateSet);

        List<Integer> duplicate = list.stream()
                .filter(num -> !intSet.add(num))
                .collect(Collectors.toList());

        System.out.println(duplicate);
        System.out.println(intSet);

        String str = "geeksforgeeks";
        char targetChar = 'g';

        long count = str.chars()                        // Convert the string to an IntStream of character codes
                .mapToObj(c -> (char) c)      // Convert each codes to a Character object
                .filter(c -> c == targetChar)    // Filter only characters that match the target character
                .count();                    // Count the filtered characters

        System.out.println("Number of occurrences of '" + targetChar + "': " + count);


    }
}
