package com.subham.Practice.Others.Java8Features.Stream;

import java.util.ArrayList;
import java.util.List;

/*Given a list of Person objects, filter all adults (age >= 18) and collect their names into a list.*/
public class PersonClassFilter {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Person person1 = new Person();
        person1.setAge(26);
        person1.setName("Sheetal");
        personList.add(person1);

        Person person2 = new Person();
        person2.setAge(30);
        person2.setName("Dheeraj");
        personList.add(person2);

        Person person3 = new Person();
        person3.setAge(18);
        person3.setName("Babun");
        personList.add(person3);

        Person person4 = new Person();
        person4.setAge(28);
        person4.setName("Subham");
        personList.add(person4);

        Person person5 = new Person();
        person5.setAge(15);
        person5.setName("Bob");
        personList.add(person5);

        List<Person> filteredPersonList = personList
                .stream()
                .filter(personObj->personObj.getAge()>18)
                .toList();

        List<String> filteredNameList = personList
                .stream()
                .filter(personObj->personObj.getAge()>18)
                .map(Person::getName)
                .toList();

        System.out.println("before filtering : " + personList);
        System.out.println("Person object list post filtering : " + filteredPersonList);
        System.out.println("name list post filtering : " + filteredNameList);

    }
}
