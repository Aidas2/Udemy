package standartTest_01;


//Given:

import java.util.*;

class Student {
}

public class Q7TestClass {

//    var students = new ArrayList<Student>(); //1

    public static void main(String[] args) {

        var student = new Student(); //2

        var allStudents = new ArrayList<>();  //3

        allStudents.add(student); //4

        for (var s : allStudents) { //5
            System.out.println(s);
        }
//        Student s2 = allStudents.get(0); //6
    }

}
//    Which lines will cause compilation error?
/*
    1 var declaration is allowed only inside method body and for loop declarations. It is not allowed to declareclass/instance
     fields, method parameters, or method return types.
    2
    3
    4
    5
    6 Observe that new ArrayList<>() means the type of the objects in the list is not known.
    So, you cannot assign an object retrieved from this list to a Student variable. Had it been new ArrayList<Student>(),
    the assignment would have been valid.
 */
