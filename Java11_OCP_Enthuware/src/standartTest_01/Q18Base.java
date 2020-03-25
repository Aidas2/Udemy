package standartTest_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

//Given:
class Base {
    public <T> Collection<T> getCollection(T t, Integer n) {
        return new ArrayList<T>();
    }
}

class Derived extends Base {

    public  <T> List<T> getCollection(T t, Integer m) { return new ArrayList<T>(); }; //1

//    public  <T> Stream<T> getCollection(T t, Integer m) { return new ArrayList<T>(); }; //2

//    public  <T> void getCollection(T t, Integer m) { return new ArrayList<T>(); }; //3

    public  <T> List<T> getCollection(String t, Integer m) { return new ArrayList<T>(); }; //4
}


//    Identify correct statements about the methods defined in Derived assuming they are uncommented one at a time individually.