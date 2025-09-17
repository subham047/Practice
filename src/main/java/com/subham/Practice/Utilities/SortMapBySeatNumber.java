package com.subham.Practice.Utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class SortMapBySeatNumber {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        //This sorting works if key contains one letter at end of the string. Also key shouldn't contain duplicate numeric key as "23a", "23b", "23c"...
        Map<String, Integer> map = new TreeMap<>(
                Comparator.comparingInt(key -> Integer.parseInt(key.substring(0, key.length() - 1))));

        map.put("11a", 1);
        map.put("34a", 1);
        map.put("13a", 8);
        map.put("78a", 2);
        map.put("7a", 5);
        map.put("1a", 7);
        map.put("21a", 1);
        map.put("2a", 1);
        map.put("2456a", 1);

        System.out.println(map);
    }

}
