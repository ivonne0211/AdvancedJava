package edu.bhcc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*Use hashmap to create VendingMachine inventory list*/
public class VendingMachine {
    private final Map<String, Slot> inventory = new HashMap<>();
    private double totalSales = 0.0;

    /* Stock items in a specific slot*/
    public void stockItems(String location, Stack<Product> productList, double unitPrice) {
        inventory.put(location, new Slot(location, productList, unitPrice));
    }

    /* Print the inventory list*/
    public void printInventory() {
        for (Map.Entry<String, Slot> entry : inventory.entrySet()) {
            Slot slot = entry.getValue();
            System.out.println(slot.getLocation());
            for (Product product : slot.getProductList()) {
                System.out.println("- " + product.getProductName());
            }
        }
    }

    /* Return the total sales */
    public double getTotalSales() {
        return totalSales;
    }

    /* Create purchase method and exceptions*/
    public VendingMachineOutput purchase(String location, double amount) {
        Slot slot = inventory.get(location);
        /* Exception for invalid slot */
        if (slot == null) {
            throw new IllegalArgumentException("Invalid slot location.");
        }

        Stack<Product> products = slot.getProductList();
        /* Exception for empty stock */
        if (products.isEmpty()) {
            throw new IllegalArgumentException("No products available in this slot.");
        }
        /* Exception for insufficient fund  */
        if (amount < slot.getUnitPrice()) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        //Dispense the first in stock item from the machine when purchased
        Product product = products.pop();
        //Calculate the change for the customer
        double change = amount - slot.getUnitPrice();
        //Update the total sales by adding the unit price into it
        totalSales += slot.getUnitPrice();

        return new VendingMachineOutput(product, change);
    }

    //Create slot within the vending machine
    private static class Slot {
        private final String location;
        private final Stack<Product> productList;
        private final double unitPrice;

        //Constructor
        public Slot(String location, Stack<Product> productList, double unitPrice) {
            this.location = location;
            this.productList = productList;
            this.unitPrice = unitPrice;
        }

        //Return the location of the product
        public String getLocation() {
            return location;
        }

        //Return the stack of products in the slot
        public Stack<Product> getProductList() {
            return productList;
        }

        //Return the item price
        public double getUnitPrice() {
            return unitPrice;
        }
    }
}