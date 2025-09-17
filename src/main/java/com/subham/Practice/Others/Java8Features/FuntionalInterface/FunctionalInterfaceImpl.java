package com.subham.Practice.Others.Java8Features.FuntionalInterface;


public class FunctionalInterfaceImpl {
    public static void main(String[] args) {

        System.out.println("FunctionalInterface...");
        FunctionalInterface obj1 = (int a, int b) -> (a * b);
        FunctionalInterface obj2 = (int a, int b) -> (a + b);
        System.out.println("obj1 result : " + obj1.calculate(5, 6));
        System.out.println("obj2 result : " + obj2.calculate(10, 10));

        System.out.println();

        System.out.println("FunctionalInterface1...");
        FunctionalInterface1 obj3 = (a) -> (a * a);
        FunctionalInterface1 obj4 = (a) -> (a + 20);
        FunctionalInterface1 obj5 = (a) -> (a - 20);

        System.out.println("obj3 result : " + obj3.logic(5));
        System.out.println("obj4 result : " + obj4.logic(20));
        System.out.println("obj5 result : " + obj5.logic(90));


    }
}
