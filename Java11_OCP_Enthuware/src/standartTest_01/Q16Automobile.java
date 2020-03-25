package standartTest_01;

//Given the following classes, what will be the output of compiling and running the class Truck?
class Q16Automobile {
    public void drive() {
        System.out.println("Automobile: drive");
    }
}

class Truck extends Q16Automobile {
    public void drive() {
        System.out.println("Truck: drive");
    }

    public static void main(String args[]) {
        Q16Automobile a = new Q16Automobile();
        Truck t = new Truck();
        a.drive(); //1
        t.drive(); //2
//        a = t;     //3
        t = (Truck) a;
        a.drive(); //4
    }
}


//End of Code