package com.udemy.section12.collections.lecture158_CHALLENGEAidas;

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
        System.out.println("========This is for aidasBasket ==================================");
        Basket aidasBasket = new Basket("Aidas");
        sellItem(aidasBasket, "cup", 100);
        sellItem(aidasBasket, "juice", 5);
        removeItem(aidasBasket, "cup", 1);
        System.out.println(aidasBasket);

        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(timsBasket, "car", 1)); //should not remove any

        System.out.println(timsBasket);

        //remove all items from timsBasket
        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(aidasBasket);
        System.out.println(stockList);
        checkOut(aidasBasket);
        System.out.println(aidasBasket);
        System.out.println(stockList);


        System.out.println("=================================================================");
        // this is test (should not allow add using another method then defined):
//        temp = new StockItem("pen", 1.12);
//        stockList.addStock(temp); // right method
//        stockList.Items().put(temp.getName(), temp); //wrong method

        // this shows, that though list is unmodifiable, but list elements isn't:
        //version without checking (throws NullPointerException of there is no items):
        stockList.Items().get("car").adjustStock(2000);         // one way
        stockList.getStockItem("car").adjustStock(-1000); //another way

        // version with checking if get("car") not returning null:
        StockItem car = stockList.Items().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            car.adjustStock(-1000);
        }

        System.out.println(stockList);

        // this shows, that list is unmodifiable, list elements are too:
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

        System.out.println("=================================================================");
        System.out.println("=================================================================");
        checkOut(timsBasket);
        System.out.println(timsBasket);


    }

    //this method just "moves" item from stock to basket (not selling, not checkouted yet)
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock first
        StockItem stockItem = stockList.getStockItem(item);
        if(stockItem == null) {
            System.out.println("We do not sell " + item + " (it isn't in stockList).");
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);

        }
        return 0; //means we didn't have sufficient stock
    }

    //this method just "moves" item from basket back to stock
    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve the item from the stock first
        StockItem stockItem = stockList.getStockItem(item);
        if(stockItem == null) {
            System.out.println("We do not sell " + item + " (it isn't in stockList).");
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);

        }
        return 0; //means we didn't have sufficient stock
    }

    //this method sells (finally  :) !!! )

    public static void checkOut(Basket basket ) {
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
