package com.subham.Practice.Others.Java8Features.Stream;

import java.util.Optional;

public class FirstNonRepeatedCharacters {
    public static void main(String[] args) {
        String word = "swiss";

        char firstNonRepeatChar = word.chars().mapToObj(charObj -> (char)charObj).filter(charObj -> word.indexOf(charObj)==word.lastIndexOf(charObj)).findFirst().orElseThrow();


        Optional<Character> output = word
                .chars()  /*This takes your string "swiss" and turns it into a stream of numbers — each character becomes its Unicode number.*/
                .mapToObj(charObj -> (char) charObj)  /*Each number is converted back into a character (we're just turning the Unicode back into readable letters).*/
                .filter(character -> word.indexOf(character) == word.lastIndexOf(character))
                .findFirst();

        System.out.println("first non repeated characters : " + (output.isPresent() ? output.get() : "output not present"));

    }
}
