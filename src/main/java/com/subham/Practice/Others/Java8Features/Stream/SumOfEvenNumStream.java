package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Arrays;
import java.util.List;

public class SumOfEvenNumStream {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(2, 4, 3, 5, 1, 5, 6, 9, 7, 3, 19, 21, 30);
        int sumNum = intList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(integerNum -> integerNum)
                .sum();
        System.out.print("result : " + sumNum);
    }
}
