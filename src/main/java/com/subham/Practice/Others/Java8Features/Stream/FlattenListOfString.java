package com.subham.Practice.Others.Java8Features.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenListOfString {
    public static void main(String[] args) {
        List<List<String>> stringList = new ArrayList<>();
        List<String> list1 = Arrays.asList("subham", "dheeraj");
        List<String> list2 = Arrays.asList("sheetal", "xyz");
        stringList.add(list1);
        stringList.add(list2);
        System.out.println("originalList : " + stringList);

        List<String> resultList = stringList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("resultList : " + resultList);
    }
}
