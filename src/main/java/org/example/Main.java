package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();

        Sewer sewer1 = employeeFactory.hireSewer("Ana", Arrays.asList(ProductCatalog.Products.SKIRT, ProductCatalog.Products.COAT, ProductCatalog.Products.PANTS));
        Sewer sewer2 = employeeFactory.hireSewer("Ioana", Arrays.asList(ProductCatalog.Products.SKIRT, ProductCatalog.Products.SHIRT, ProductCatalog.Products.PANTS, ProductCatalog.Products.COAT));

        Team team = new Team(Arrays.asList(sewer1, sewer2));
        TeamResponsible teamResponsible = employeeFactory.hireTeamResponsible("Maria", team);
        employeeFactory.printEmployees();


        OrderBuilder orderBuilder = new OrderBuilder();

        List<Order> orders = orderBuilder
                .addOrder("Camelia", ProductCatalog.Products.SKIRT)
                .addOrder("Carmen", ProductCatalog.Products.PANTS)
                .addOrder("Teodora", ProductCatalog.Products.SHIRT)
                .addOrder("Elena", ProductCatalog.Products.COAT)
                .addOrder("Rodica", ProductCatalog.Products.PANTS)
                .addOrder("Iulia", ProductCatalog.Products.SHIRT)
                .addOrder("Ziana", ProductCatalog.Products.COAT)
                .addOrder("Paula", ProductCatalog.Products.PANTS)
                .build();

        teamResponsible.notifyAllTeam(orders);
    }
}