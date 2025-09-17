package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*Second highest number*/
public class SecondHighest {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(8, 2, 5, 7, 3, 4, 6, 1);
        Optional<Integer> secondMaxOptional = numberList
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println("second highest number : " + (secondMaxOptional.isPresent() ? secondMaxOptional.get() : "secondMaxOptional not present"));
    }
}
