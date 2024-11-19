package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * TeamResponsible uses a behavioral pattern, Visitor
 */
public class TeamResponsible extends Employee implements SewerVisitor {

    private Team team;
    private static final String FILE_PATH = "/Users/heteal/Desktop/JAVA/designPatternsHomework/resources/sewerStatus.txt";
    public TeamResponsible(int employeeId, String name, Team team) {
        super(employeeId, name);
        this.team = team;
    }

    @Override
    public void visitStatus(Sewer sewer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String status = sewer.isAvailable() ? "Available" : "Busy";
            writer.write(String.format("ID: %d, Name: %s, Status: %s",
                    sewer.getEmployeeId(),
                    sewer.getName(),
                    status));
            writer.newLine();
        } catch (IOException e) {
            System.err.println(STR."Failed to write to file: \{e.getMessage()}");
            e.printStackTrace();        }
    }

    public void notifyAllTeam(List<Order> orders) {
        for (Order order : orders) {
            boolean orderAssigned = false;

            while (!orderAssigned) {
                for (Sewer sewer : team.getSewers()) {
                    if (sewer.isAvailable()) {
                        sewer.notifyMe(order);
                        accept(sewer);
                        orderAssigned = true;
                        break;
                    }
                }

                if (!orderAssigned) {
                    try {
                        System.out.println("No sewer is available, waiting for the first one to finish...");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void accept(Sewer sewer) {
        sewer.accept(this);
    }
}