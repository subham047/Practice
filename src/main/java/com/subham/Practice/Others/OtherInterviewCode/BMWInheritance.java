package com.subham.Practice.Others.OtherInterviewCode;

public class BMWInheritance extends Car {
    public static void main(String[] args) {

//    BMW Obj = new Car()
        Car car = new BMWInheritance();
        BMWInheritance bmw = new BMWInheritance();
        bmw.start();
        car.start();
        
    }

    public void start() {
        System.out.println("BMW is getting started");
        super.start();
    }

}
