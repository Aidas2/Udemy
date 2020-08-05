package section_08_methods.methods_with_variable_arguments.accessModifiers;

import section_08_methods.methods_with_variable_arguments.accessModifiers.common.Common;

/**
 * @author goran on 12/07/2017.
 */
public class UsingAccessModifiers {

    public static void main(String[] args) {
        Common common = new Common();
        common.publicPrint();
//        common.protectedPrint();
//        common.defaultPrint();
//        common.privatePrint();

        System.out.println("publicNumber= " + common.publicNumber);
//        System.out.println("protectedNumber= " + common.protectedNumber);
//        System.out.println("defaultNumber= " + common.defaultNumber);
//        System.out.println("privateNumber= " + common.privateNumber);
    }
}
