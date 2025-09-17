package com.subham.Practice.Others.Java8Features.Stream;

import java.util.List;

/*Count how many strings in a list have length more than 5*/
public class CountFilteredString {
    public static void main(String[] args) {
        List<String> namesList = List.of("Subham", "Amrit", "Alok", "Sheetal", "Asu", "Amber", "Dheeraj", "Ash");

        long count = namesList
                .stream()
                .filter(name -> name.length() > 5)
                .count();

        System.out.println("Count of strings in a list have length more than 5 =  " + count);


    }
}
