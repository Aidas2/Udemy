package com.learnit.Comparator;

import java.util.Comparator;

public class CustomProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        int result = product1.getCategoryName().compareTo(product2.getCategoryName());
        result = result < 0 ? -1 : (result == 0 ? 0 : 1);
        return result;
    }
}
