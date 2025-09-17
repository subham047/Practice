package com.subham.Practice.Others.Java8Features.Stream;

import java.util.List;

public class UpperCase {
    public static void main(String[] args) {
        List<String> namesList = List.of("Subham", "Amrit", "Alok", "Sheetal", "Asu", "Amber", "Dheeraj", "Ash");
        List<String> filteredList = namesList
                .stream().map(name -> name.toUpperCase())
                .toList();

//        List<String> filteredList = namesList
//                .stream()
//                .map(String::toUpperCase)
//                .toList();

        System.out.println("before filtering : " + namesList);
        System.out.println("post filtering : " + filteredList);

    }
}
