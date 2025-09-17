package com.subham.Practice.Others.Java8Features.FuntionalInterface;

public class CustomInterfaceImpl {
    public static void main(String[] args) {
        CustomFuncInterface customFuncInterface = (String empName, String companyName) -> System.out.print(empName + " was working with " + companyName);
        customFuncInterface.execute("Subham", "Reward360");
    }

}
