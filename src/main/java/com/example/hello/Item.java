package com.example.hello;

public class Item {

    public String itemName;
    public Double amountPaid;
    public Double amountCharging;

    public Item(String itemName, Double amountPaid, Double amountCharging) {

        this.itemName = itemName;
        this.amountPaid = amountPaid;
        this.amountCharging = amountCharging;

    }

    public String toString() {

        return String.format("ITEM NAME: %s \n AMOUNT PAYING FOR ITEM: %d \n AMOUNT CHARGING FOR ITEM: %d", itemName, amountPaid, amountCharging);

    }
}
