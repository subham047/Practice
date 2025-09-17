package com.subham.Practice.Others.String;

public class StringRev {
    public static void main(String[] args) {
        String str = "Dheeraj";
        String revStr = "";

        char[] chararray = str.toCharArray();

        for (int i = chararray.length-1; i>=0;i--){
//            revStr+=chararray[i];
            revStr = revStr+chararray[i];
        }
        System.out.println(revStr);

        for (int i = 0;i<str.length();i++){
            revStr=str.charAt(i) + revStr;
        }
        System.out.println(revStr);




    }
}
