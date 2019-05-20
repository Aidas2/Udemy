package com.udemy.lambdaExpressions.lesson275;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        new Thread(new CodeToRun()).start();

// ==============================================================
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable2");
//            }
//        }).start();

//==============================================================
//        new Thread(() -> System.out.println("Printing from Runnable3")).start();

        new Thread(() -> {
            System.out.println("Printing from Runnable4");
            System.out.println("Line2");
            System.out.format("This is line %d\n", 3);
        }).start();

        System.out.println("====================================================================================================");

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hull+", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//==============================================================
//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));

//==============================================================
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));


        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString1 = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString1);

//        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();

//==============================================================
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString2 = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString2);


        System.out.println("====================================================================================================");
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }


}

//class CodeToRun implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable1");
//    }
//}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {
//        System.out.println("The Anotherclass class's name is (01): " + getClass().getSimpleName()); //AnotherClass
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName()); //empty
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

//==============================================================
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());   //AnotherClass
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        System.out.println("The Anotherclass class's name is (02): " + getClass().getSimpleName()); //AnotherClass
//        return Main.doStringStuff(uc, "String3", "String4");

//==============================================================
        //this is nested block:
//        final int i = 0;
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("i (within anonymous class)= " + i);
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//            System.out.println("The Anotherclass class's name is (02): " + getClass().getSimpleName()); //AnotherClass
//
//            //i++;
//            System.out.println("i= " + i);
//
//            return Main.doStringStuff(uc, "String5", "String6");

//==============================================================
//            int i = 0;
//
//            UpperConcat uc = (s1, s2) -> {
//                System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
//                String result = s1.toUpperCase() + s2.toUpperCase();
//                return result;
//            };
//
//            return Main.doStringStuff(uc, "String7+", "String8");

//Lecture 278: ==============================================================
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

//03:46 minute stopped copying ;)
        System.out.println("The Anotherclass class's name is (278): " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String7+", "String8");

    }
}

