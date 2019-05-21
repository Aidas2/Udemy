package com.udemy.section16.lambdaExpressions.lesson286CHALLENGES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // === CHALLENGE #1 ==========================================================================================
        //Write the following anonymous class as a lambda expression:

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        // === CHALLENGE #2 ==========================================================================================
        //Write the following method as a lambda expression. Don't worry about assigning it to anything:

//        public static String everySecondChar(String source) {
//            StringBuilder returnVal = new StringBuilder();
//            for (int i = 0; i < source.length(); i++) {
//                if (i % 2 == 1) {
//                    returnVal.append(source.charAt(i));
//                }
//            }
//
//            return returnVal.toString();
//        };

        Function<String, String> lambdaFunction =  (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        // === CHALLENGE #3 ==========================================================================================
        //Right now, the function doesn't do anything.
        // Write the code that will execute the function with an argument of "1234567890":

        System.out.println(lambdaFunction.apply("1234567890"));

        // === CHALLENGE #4 ==========================================================================================
        //Instead of executing this function directly, suppose we want to pass it to a method.
        //Write a method called everySecondCharacter that accepts the function as a parameter and executes it with the argument "1234567890"
        //It should return the result of the function. For bonus points, don't hard-code the argument string within the method.

        //version with "hardcoded" string:
//        private static String everySecondCharacter2(Function <String, String> lambdaFunction) {
//            return lambdaFunction.apply("1234567890");
//        }
        //version with not "hardcoded" string:
//        private static String everySecondCharacter2(Function <String, String> lambdaFunction, String s) {
//            return lambdaFunction.apply(s);
//        }

        // === CHALLENGE #5 ==========================================================================================
        //Using the bonus version, call the method with the lambdaFunction we created earlier and the string "1234567890".
        //print the result returned from the method.

        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        // === CHALLENGE #6 ==========================================================================================
        //Now write a lambda expression that maps to the java.util.Supplier interface.
        // This lambda should return the string "I love Java !" Assign it to variable called iLoveJava.

        //version#1
        Supplier<String> iLoveJava1 = () -> "I love Java!";

        //version#2
        Supplier<String> iLoveJava2 = () -> { return "I love Java!"; };

        // === CHALLENGE #7 ==========================================================================================

        //As with Function, the Supplier won't do anything until we use it.
        //Use this supplier to assign the string "I love Java !" to a variable called supplierResult.
        //Then print the variable to the console.

        String supplierResult = iLoveJava2.get();
        System.out.println(supplierResult);

        // === CHALLENGE #9 ==========================================================================================
        //Write code to print the items in the list in sorted order, and with the first letter in each upper-cased.
        //The name "harry" should be printed as "harry" and should be printed after "Emily" and before "Isla".
        //use lambda expressions wherever possible.

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        System.out.println("=== #9 My version ==============");
        List<String> sorted =
                topNames2015.stream()
                .map(n -> n.substring(0,1).toUpperCase() + n.substring(1))
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

        for(String s : sorted) {
            System.out.println(s);
        }

        System.out.println("=== #9 Tim's version 1 ==============");
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));

        // === CHALLENGE #10 ==========================================================================================
        //Change the code so that it uses method references.
        //Remember that a method reference looks like Class:MethodName

        System.out.println("=== #10 Tim's version 2 (method references) ==============");
        List<String> firstUpperCaseList2 = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList2.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList2.sort(String::compareTo);
        firstUpperCaseList2.forEach(System.out::println);

        // === CHALLENGE #11 ==========================================================================================
        //Now do the same thing (uppercase first letter, then sort and print the list) using stream and a chain of stream operations.

        System.out.println("=== #11. Tim's version 3 (stream) ==============");
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // === CHALLENGE #12 ==========================================================================================
        //Instead of printing out the sorted names, print out how many names begins with the letter "A" instead.

        System.out.println("=== #12.Starts with A. My version  ==============");
        long count = topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted(String::compareTo)
                .filter(s -> s.startsWith("A"))
                .count();
                //.forEach(System.out::println);
        System.out.println(count);

        System.out.println("=== #12.Starts with A. Tim's version  ==============");
        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);

        // === CHALLENGE #13, 14 ==========================================================================================

        System.out.println("=== #13, 14 .using peek(). Tim's version  ==============");
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList()); // or count()

    }

    //method for Challenge #4:
    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}












