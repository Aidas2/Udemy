/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 12: Understanding Modules
Topic: Declare modules and enable access between modules
*/

package org.pkg.entity;

import org.pkg.appglobals.ApplicationConstants;
import org.pkg.util.Countable;

public class BaseEntity implements Countable {

    // Constructor calls the countMe method
    public BaseEntity() {
        countMe();
    }

    // main method creates several objects then prints out how many
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            BaseEntity b1 = new BaseEntity();
        }
        System.out.println(ApplicationConstants.APP_NAME + " created " +
                ApplicationConstants.getCounter() + " objects ");
    }

    // countMe implements Countable.countMe method
    public void countMe() {
        ApplicationConstants.addCounter();
    }
}

/*
aidas@aidas-X550CL:~/Documents/Udemy_etc/Java11_OCP_Modules/out/production$
ls -li
jdeps org.module.global
jdeps --list-deps org.module.global
jdeps org.module.util // error, needs path
jdeps --module-path . org.module.util
jdeps --module-path . --list-deps org.module.util
jdeps --module-path . org.module.base

jdeps -v org.module.global
jdeps -verbose org.module.global
jdeps -s org.module.global
jdeps -summary org.module.global
jdeps -summary org.module.global org.module.util
java --module-path . --describe-module org.module.global
java --module-path . --describe-module org.module.util
jdeps -summary org.module.global org.module.util org.module.base
jdeps -summary org.module.global org.module.util org.module.base org.module.concrete
 */