package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderBuilder uses a creational pattern, Builder
 */
public class OrderBuilder {

    private List<Order> orders = new ArrayList<>();

    public OrderBuilder addOrder(String customerName, ProductCatalog.Products product) {
        Customer customer = new Customer(customerName);
        orders.add(new Order(customer, product));
        return this;
    }

    public List<Order> build() {
        return orders;
    }
}