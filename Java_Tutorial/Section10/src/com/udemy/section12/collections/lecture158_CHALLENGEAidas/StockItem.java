package com.udemy.section12.collections.lecture158_CHALLENGEAidas;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity >= 0.0) {
            this.quantityInStock = newQuantity;
        }
    }

    // those two methods only returns how mush reserved increased/decreased (not how many left in stock)
    public int reserveStock (int quantityToReserve) {
        if (quantityToReserve <= availableQuantity()) //use the method, not field !
        {
            reserved += quantityToReserve;
            return quantityToReserve; //why ? why not reserved ?
        }
        return 0;
    }

    public  int unreserveStock (int quantityToUnreserve) {
        if (quantityToUnreserve <= reserved) {
            reserved -= quantityToUnreserve;
            return quantityToUnreserve;
        }
        return 0;
    }

    // method to reduce quantity in stock and reserved after checkout:
    public int finaliseStock(int quantityForCheckout) {
        if(quantityForCheckout <= reserved) {
            quantityInStock -= quantityForCheckout;
            reserved -= quantityForCheckout;
            return quantityForCheckout;
        }
        return 0;
    }



    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if(obj == this) {
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo()");
        if(this == o) {
            return 0;                           //returns 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());   //returns 1 or -1
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved " + this.reserved;
    }
}
