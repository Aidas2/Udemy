package section_09_class_design.data_encapsulation;

/**
 * @author goran on 14/07/2017.
 */
public class DataEncapsulation {

    public static void main(String[] args) {
        Company company = new Company();
        company.setName("MyCompany");
        company.addEmployee("John");
        company.addEmployee("Anthony");
        company.addEmployee(null);
        company.addEmployee("");

        company.setName(null);

        company.printSorted();

//        company.name = null;
//        company.printSorted();

//        company.employees = null;

//        company.employees.add("Jimmy");
//        company.printSorted();
    }
}
