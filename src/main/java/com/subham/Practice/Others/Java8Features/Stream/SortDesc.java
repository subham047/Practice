package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Comparator;
import java.util.List;

/*Sort a list of integers in descending order.*/
public class SortDesc {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(2, 25, 36, 12, 14, 8, 7, 5, 69, 32);
        List<Integer> filteredList = numberList
                .stream()
                .sorted(Comparator.reverseOrder()).toList();

        System.out.println("before filtering : " + numberList);
        System.out.println("post filtering : " + filteredList);

    }
}
