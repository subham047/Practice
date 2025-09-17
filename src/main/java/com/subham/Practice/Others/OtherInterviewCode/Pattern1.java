package com.subham.Practice.Others.OtherInterviewCode;


/*
    1
   21
  321
4321
*/

public class Pattern1 {
    public static void main(String[] args) {
        int input = 4;
        for (int row = 1; row <= input; row++) {
            int noOfSpace = input - row;
            for (int startSpace = 1 ; startSpace<=noOfSpace ; startSpace++){
                System.out.print( " ");
            }
            for (int number = row; number >=1; number --){
                System.out.print(number);
            }
            System.out.println();
        }
    }
}
