package section_02_basics.academy.learnprogramming;

// import java.sql.*;

import java.util.List;

/**
 * @author goran on 24/06/2017.
 */
public class ConflictExample {

    public static void main(String[] args) {
        java.util.Date date;
        java.sql.Date sqlDate;

    }

    public void checkEmpty(List list) {
        if (list.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
    }

    public class LineNumbers {
        public void checkEmpty(List list) {
            if (list.isEmpty()) {
                System.out.println("empty");
            } else {
                System.out.println("not empty");
            }
        }
    }
}
