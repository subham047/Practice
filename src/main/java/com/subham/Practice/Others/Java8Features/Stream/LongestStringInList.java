package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringInList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "pear", "pineapple");

        String longestObj = words.stream().max(Comparator.comparingInt(obj -> obj.length())).orElse("");
        System.out.println(longestObj);

    }
}
