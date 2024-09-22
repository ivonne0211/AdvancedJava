package edu.bhcc;

/* Create an abstract class Product */
public abstract class Product {
    protected String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    /*this abstract method consume the product*/
    public abstract void consume();
}

/*Inheritance Drink class */
class Drink extends Product {
    public Drink(String productName) {
        super(productName);
    }

    //Simulate when drink consumed
    @Override
    public void consume() {
        System.out.println("Yum, you drink the " + this.productName + ".");
    }
}

/*Inheritance Snack class */
class Snack extends Product {
    public Snack(String productName) {
        super(productName);
    }

    //Simulate when snack consumed
    @Override
    public void consume() {
        System.out.println("Yum, you eat the " + this.productName + ".");
    }
}