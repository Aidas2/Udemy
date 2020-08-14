/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 12: Understanding Modules
Topic: Describe how a modular project is compiled and run.
*/

package modular;

//public class HelloWorld {
//    public static void main(String[] args) {
//        System.out.println("Hello new modular world");
//    }
//}

import mod2.GoodbyeWorld;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello new modular world");
        GoodbyeWorld.main(args);
    }
}
/*
aidas@aidas-X550CL:~/Documents/Udemy_etc/Java11_OCP_Modules$
java --module-path out/production/ -m MyFirstModule/modular.HelloWorld
jar --create --file MyFirstModule.jar --main-class modular.HelloWorld -C out/production/MyFirstModule/ .
jar -f MyFirstModule.jar --list
jar -f MyFirstModule.jar -d
java --module-path . --describe-module MyFirstModule
java -p . -d MyFirstModule
java --module-path . --module MyFirstModule
jdeps MyFirstModule.jar

jar --create --file MyFirstModule.jar --main-class modular.HelloWorld -C out/production/MyFirstModule/ .
jar --create --file out/MySecondModule.jar -C out/production/MySecondModule/ .
java --dry-run -p . -m MyFirstModule
java --dry-run -p .:out -m MyFirstModule  // ;out for Windows
java -p .:out -m MyFirstModule            // ;out for Windows
jdeps --module-path .:out MyFirstModule.jar
jdeps --module-path .:out -m MyFirstModule
jdeps --module-path .:out --list-deps MyFirstModule.jar
jdeps --module-path .:out --list-deps -m MyFirstModule
jdeps --module-path .:out --check MyFirstModule
*/




