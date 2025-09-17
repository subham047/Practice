package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Map;
import java.util.stream.Collectors;

public class OccuranceStream {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        // Convert the string into a stream of characters and count occurrences
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        // Print the result
        System.out.println(charCount);
    }
}
