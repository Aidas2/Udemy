package com.udemy.section12.collections.lecture154_SortedMapsSets;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.5, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7); //checking if can add same item
        stockList.addStock(temp);


        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        System.out.println("=================================================================");
        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(sellItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        };
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        System.out.println("=================================================================");
        // this is test (should not allow add using another method then defined):
//        temp = new StockItem("pen", 1.12);
//        stockList.addStock(temp); // right method
//        stockList.Items().put(temp.getName(), temp); //wrong method

        // this shows, that though list is unmodifiable, but list elements isn't:
        stockList.Items().get("car").adjustStock(2000);         // one way
        stockList.getStockItem("car").adjustStock(-1000); //another way
        System.out.println(stockList);

        // this shows, that list is unmodifiable, list elements are too:
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }










    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock first
        StockItem stockItem = stockList.getStockItem(item);
        if(stockItem == null) {
            System.out.println("We do not sell " + item + " (it isn't in stockList).");
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;

        }
        return 0; //means we didn't have sufficient stock
    }

}
