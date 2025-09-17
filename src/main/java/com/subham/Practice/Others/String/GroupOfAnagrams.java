package com.subham.Practice.Others.String;

import java.util.*;

public class GroupOfAnagrams {
    public static void main(String[] args) {
            String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
//            String[] strArr = {""};
//        String[] strArr = {"a"};


        Map<String, List<String>> map = new HashMap<>();

        for (String str : strArr) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        System.out.print(new ArrayList<>(map.values()));
    }
}
