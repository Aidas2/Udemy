package section_01;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Create an executable Java program
*/

public class PrintArgs {

    public static void main(String[] args) {

        System.out.println("Printing some arguments in this code: ");

        // Loop through arguments passed and print them to standard output
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + (i + 1) + ": " + args[i]);
        }
    }
}

// C:\Udemy_etc\Java11_OCP>java -cp out/production/Java11_OCP/section_01 PrintArgs
// C:\Udemy_etc\Java11_OCP>java -classpath out/production/Java11_OCP section_01.PrintArgs Test1 Test2 Test3

// C:\Udemy_etc\Java11_OCP>java --class-path out/production/Java11_OCP section_01.PrintArgs One1,Two2,Three3 "Two Three" 'Four Five'


