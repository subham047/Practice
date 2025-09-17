package com.subham.Practice.Others.Java8Features.Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NamesListToMap {
    public static void main(String[] args) {
        List<String> namesList = List.of("Subham", "Amrit", "Alok", "Sheetal", "Asu", "Amber", "Dheeraj", "Ash");
        Map<String, Integer> filteredMap = namesList
                .stream()
                .collect(Collectors.toMap(name -> name, name -> name.length()));

        System.out.println("before filtering : " + namesList);
        System.out.println("post filtering : " + filteredMap);

    }
}
