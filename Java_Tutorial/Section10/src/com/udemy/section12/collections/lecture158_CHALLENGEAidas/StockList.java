package com.udemy.section12.collections.lecture158_CHALLENGEAidas;

import java.util.Collections;
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
                item.adjustStock(inStock.availableQuantity());
            }

// version_2:
//            StockItem inStock = list.get(item.getName());
//            if (inStock != null) {
//                item.adjustStock(inStock.availableQuantity());
//            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String itemNameAsMapKey, int quantityToSell) {
//        StockItem inStock = list.getOrDefault(itemNameAsMapKey, null);
//
//        if((inStock !=null) && (inStock.availableQuantity() >= quantityToSell) && (quantityToSell >0)) {
//
//            inStock.adjustStock(-quantityToSell);
//            return quantityToSell;
//        }
//        return 0;   //that means we can't sell (0 will be used in if condition)

        StockItem inStock = list.get(itemNameAsMapKey);
        if((inStock != null) && (quantityToSell >0)) {
            return inStock.finaliseStock(quantityToSell);
        }
        return 0;

    }

    public int reserveStock (String itemNameAsMapKey, int quantityToReserve) {
        StockItem inStock = list.get(itemNameAsMapKey);
        if((inStock != null) && (quantityToReserve > 0)) {
            return inStock.reserveStock(quantityToReserve);
        }
        return 0;
    }

    public int unreserveStock(String itemNameAsMapKey, int quantityToUnreserve) {
        StockItem inStock = list.get(itemNameAsMapKey);
        if((inStock != null) && (quantityToUnreserve > 0)) {
            return inStock.unreserveStock(quantityToUnreserve);
        }
        return 0;
    }


    public StockItem getStockItem (String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        //return prices; //too primitive :)
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        //return list; //too primitive :)
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
