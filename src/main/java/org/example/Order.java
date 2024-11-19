package org.example;

/**
 * Order acts as a trigger for notifying the Sewers about a new task to process, uses a behavioral pattern, observer
 */
public class Order {
    private Customer customer;
    private final ProductCatalog.Products product;

    public Order(Customer customer, ProductCatalog.Products product) {
        this.customer = customer ;
        this.product = product;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public ProductCatalog.Products getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return STR."Order{customerName='\{customer.getName()}\{'\''}, product=\{product}\{'}'}";
    }
}
