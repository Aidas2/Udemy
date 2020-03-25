package standartTest_01;

class A {
    public A() {
    }

    public A(int i) {
        System.out.println(i);
    }
}

class B {
    static A s1 = new A(1);
    A a = new A(2);

    public static void main(String[] args) {
        B b = new B();
        A a = new A(3);
    }

    static A s2 = new A(4);
}
//    Which is the correct sequence of the digits that will be printed when B is run?