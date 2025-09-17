package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class MaxDifference {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 3, 40, 5, 60);

        // Find the maximum value
        OptionalInt maxOptional = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();

        // Find the minimum value
        OptionalInt minOptional = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();

        // Calculate the maximum difference
        if (maxOptional.isPresent() && minOptional.isPresent()) {
            int maxDifference = maxOptional.getAsInt() - minOptional.getAsInt();
            System.out.println("Maximum difference: " + maxDifference);
        } else {
            System.out.println("List is empty");
        }
    }
}