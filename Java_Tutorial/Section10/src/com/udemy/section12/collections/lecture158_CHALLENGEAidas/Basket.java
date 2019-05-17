package com.udemy.section12.collections.lecture158_CHALLENGEAidas;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name; //name of Basket
    private final Map<StockItem, Integer> list; // key - object itself; value - ordered quantity

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    //this method increases quantity of item in basket:
    public int addToBasket(StockItem item, int quantityToAdd) {
        if ((item != null) && (quantityToAdd > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantityToAdd); //it means that we updating

            return inBasket; //shows quantity before adding, why ? Why not quantityToAdd e.c. quantity to increase ?
        }
        return 0;
    }

    //this method decreases quantity of item in basket (not removes item itself (only in case then newQuantity becomes 0)):
    public int removeFromBasket(StockItem item, int quantityToRemove) {
        if((item != null) && (quantityToRemove > 0)) {
            //check if we already have the item in the basket:
            int inBasket = list.getOrDefault(item, 0); //returns int (value of map by key)
            int newQuantity = inBasket - quantityToRemove; //why not minus ????? --> cha cha, Tim fixed later :)

            if(newQuantity > 0) //it means that some quantity still left and therefore must be updated according to new value)
            {
                list.put(item, newQuantity); //why put if we need to remove ????? --> just updating quantity of existing item
                return quantityToRemove; // shows how much quantity will bee decreased
            } else if (newQuantity == 0) //it means that quantity decreased to 0 and threrefore it makes sense to remove item
            {
                list.remove(item);
                return quantityToRemove; // shows how much quantity will bee decreased
            }
        }
        return 0;
    }

    public void clearBasket () {
        this.list.clear();
    }


    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + " Total cost " + totalCost;
    }
}
