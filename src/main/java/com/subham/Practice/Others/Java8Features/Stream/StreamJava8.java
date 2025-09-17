package com.subham.Practice.Others.Java8Features.Stream;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava8 {
    public static void main(String[] args) throws IOException {

        System.out.println("stream api...");
        String[] arr = {"child", "America", "Inds", "Chinas"};

        // print all the names which contains 'm' in an array
        List<String> filteredList1 = Arrays.asList(arr);
        System.out.println(filteredList1.stream().filter(names -> names.contains("m")).collect(Collectors.toList()));

        // print all the names whose length is greater than 4 in an array
        List<String> filteredList = Arrays.stream(arr).filter(names -> names.length() > 4).collect(Collectors.toList());
        System.out.println(filteredList);

        // print the first repeated character in a string
        String str = "banana";
        String[] arr1 = str.split("");
        Arrays.stream(arr1).filter(names -> str.indexOf(names) != str.lastIndexOf(names)).findFirst().ifPresent(System.out::println);


        List list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(1);
        list.add("abc");
        list.add(3.258);
        list.add(true);
        list.add('a');

        list.forEach(index -> {
            System.out.println(index);
        });

        // example
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Inserting elements to ArrayList class object
        // Custom input integer numbers
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);

        List<Integer> evenList = al.stream().filter(obj -> obj % 2 == 0).collect(Collectors.toList());
        List<Integer> evenGreaterThanFiveList = al.stream().filter(obj -> obj % 2 == 0).collect(Collectors.toList()).stream().filter(e -> e > 5).collect(Collectors.toList());
        List<Integer> mapList = al.stream().map(obj -> obj + 2).collect(Collectors.toList());
        List<Integer> sortedList = al.stream().sorted().collect(Collectors.toList());
        ;
        System.out.println("filtered even number list : " + evenList);
        System.out.println("updated list using map() : " + mapList);
        System.out.println("sorted list : " + sortedList);
        System.out.println("evenGreaterThanFive list : " + evenGreaterThanFiveList);


        // Example
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5 }, 6, 7}};
        //  [1, 2, 3, 4, 5, 6, 7]

        // Flatten the array and collect the results into a list
        List<Object> flattenedList = Arrays.stream(array)
                .flatMap(obj -> obj instanceof Object[]
                        ? Arrays.stream((Object[]) obj).flatMap(innerObj -> innerObj instanceof Object[]
                        ? Arrays.stream((Object[]) innerObj)
                        : Stream.of(innerObj))
                        : Stream.of(obj))
                .collect(Collectors.toList());

        System.out.println(Arrays.stream(array).collect(Collectors.toList()));

        // Print the flattened list
        System.out.println(" flattenedList : " + flattenedList);


        // Optional
//        String name = "subham";
        String name = null;
        Optional<String> optionalName = Optional.ofNullable(name);

        // Check if value is present
        if (optionalName.isPresent()) {
            System.out.println("Name is present: " + optionalName.get());
        } else {
            System.out.println("Name is not present");
        }

    }
}


// stream().filter() // .map()
// lamda
// functional interface
// for each
//