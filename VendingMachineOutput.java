package edu.bhcc;

/* Create the VendingMachineOutput class; it shows the output of a vending machine purchase. */
public class VendingMachineOutput {
    Product product;
    double change;

    public VendingMachineOutput(Product product, double change) {
        this.product = product;
        this.change = change;
    }
}