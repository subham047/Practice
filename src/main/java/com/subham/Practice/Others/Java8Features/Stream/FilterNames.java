package com.subham.Practice.Others.Java8Features.Stream;

import java.util.ArrayList;
import java.util.List;

/*Given a list of names, return a list of names that start with "A" and are longer than 3 characters.*/
public class FilterNames {
    public static void main(String[] args) {
        List<String> namesList = List.of("Subham", "Amrit", "Alok", "Sheetal", "Asu", "Amber", "Dheeraj", "Ash");
        List<String> filteredList = namesList
                .stream()
                .filter(name -> name.startsWith("A") && name.length() > 3)
                .toList();

        System.out.println("before filtering : " + namesList);
        System.out.println("post filtering : " + filteredList);


    }
}
