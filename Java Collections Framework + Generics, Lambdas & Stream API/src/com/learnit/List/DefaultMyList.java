package com.learnit.List;

public class DefaultMyList implements MyList {
    @Override
    public void add(Object e) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        return false;
    }
}
