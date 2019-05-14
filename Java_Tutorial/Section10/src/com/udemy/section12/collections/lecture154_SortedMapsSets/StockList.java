package com.udemy.section12.collections.lecture154_SortedMapsSets;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list; //not listInStock (this we use in implementation in main class)

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if already are stock in this item (item.getName() - gets if already exist; item - gets if doesn't exist)

//version_1:
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.getQuantityInStock());
            }

// version_2:
//            StockItem inStock = list.get(item.getName());
//            if (inStock != null) {
//                item.adjustStock(inStock.getQuantityInStock());
//            }

            list.put(item.getName(), item);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);

        if((inStock !=null) && (inStock.getQuantityInStock() >= quantity) && (quantity >0)) {

            inStock.adjustStock(-quantity);
            return quantity; //why ? why not "return inStock.getQuantityInStock()" ?;
        }
        return 0;   //that means we can't sell (0 wil be used in if)
    }

    public StockItem getStockItem (String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        //return list;
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();

            s = s + stockItem + ". There are " + stockItem.getQuantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
