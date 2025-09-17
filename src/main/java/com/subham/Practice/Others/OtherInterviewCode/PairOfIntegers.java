package com.subham.Practice.Others.OtherInterviewCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairOfIntegers {
    public static void main(String[] args) {
        int[] intArr = {1, 4, 7, 3, 9, 6, 2};
        int target = 13;

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(intArr);

        for (int i = 0; i < intArr.length; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
//                get pairs
                if (intArr[i] + intArr[j] == target) {
                    List<Integer> groupList = new ArrayList<>();
                    groupList.add(intArr[i]);
                    groupList.add(intArr[j]);
                    resultList.add(groupList);
                }
            }
        }
        System.out.print(resultList);
    }
}
