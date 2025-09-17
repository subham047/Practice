package com.subham.Practice.Others.Java8Features.Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstChar {
    public static void main(String[] args) {
        List<String> namesList = List.of("Subham", "Amrit", "Alok", "Sheetal", "Asu", "Amber", "Dheeraj", "Ash");
        Map<Character,List<String>> groupedByFirstChar = namesList
                .stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("before filtering : " + namesList);
        System.out.println("post filtering : " + groupedByFirstChar);

    }
}
