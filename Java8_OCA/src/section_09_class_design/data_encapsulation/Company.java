package section_09_class_design.data_encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author goran on 14/07/2017.
 */
// POJO (Plain Old Java Object)
public class Company {


    private String name;
    private List<String> employees = new ArrayList<>();

//    public Company() {}

    public void printSorted() {
        System.out.println("companyName= " + name);
        Collections.sort(employees);
        System.out.println("sorted= " + employees);
    }

    public void setName(String name) {
        if(name == null) {
            System.out.println("name cant be null");
            return;
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("cant add null employee");

        } else {
            employees.add(name);
        }
    }
}
