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

    public int addToBasket(StockItem item, int quantityToAdd) {
        if ((item != null) && (quantityToAdd > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantityToAdd);

            return inBasket;
        }
        return 0;
    }

    //this method removes (or adjust) quantity, not item itself:
    public int removeFromBasket(StockItem item, int quantityToRemove) {
        if((item != null) && (quantityToRemove > 0)) {
            //check if we already have the item in the basket:
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantityToRemove; //why not minus ????? cha cha, fixed later :)

            if(newQuantity > 0) //it means that quantity increased (and item should be added (updated ?)
            {
                list.put(item, newQuantity); //why put if we need to remove ?????
                return quantityToRemove;
            } else if (newQuantity == 0) //it means that quantity decreased to 0 and item should be removed
            {
                list.remove(item);
                return quantityToRemove;
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
