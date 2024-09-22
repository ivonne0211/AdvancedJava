package edu.bhcc;

import java.util.Stack;

/*Create RunVendingMachine class to test samples purchase and stock for VendingMachine class*/
public class RunVendingMachine {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        /* Stock Diet Cokes into the vending machine*/
        Stack<Product> dietCokeStack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            dietCokeStack.push(new Drink("Diet Coke"));
        }
        machine.stockItems("A1", dietCokeStack, 1.25);

        /* Stock Cliff Bars into the vending machine */
        Stack<Product> cliffBarStack = new Stack<>();
        for (int i = 0; i < 3; i++) {
            cliffBarStack.push(new Snack("Cliff Bar"));
        }
        machine.stockItems("A2", cliffBarStack, 4.00);

        machine.printInventory();

        /* Sample purchase a Diet Coke */
        VendingMachineOutput output = machine.purchase("A1", 2.00);
        System.out.println("Got: " + output.product.getProductName());
        System.out.println("Received change: " + output.change);
        output.product.consume();
        System.out.println("Total Sales: " + machine.getTotalSales());

        /* Sample Purchase a Cliff Bar */
        output = machine.purchase("A2", 5.00);
        System.out.println("Got: " + output.product.getProductName());
        System.out.println("Received change: " + output.change);
        output.product.consume();
        System.out.println("Total Sales: " + machine.getTotalSales());
    }
}