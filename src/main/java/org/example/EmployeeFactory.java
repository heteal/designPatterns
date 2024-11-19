package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeFactory uses a creational pattern, Factory
 */
public class EmployeeFactory {

    private int numberOfEmployees = 100;
    private final Map<String, Integer> employeeMap = new HashMap<>();

    public Sewer hireSewer(String name, List<ProductCatalog.Products> skills) {
        int newId = ++numberOfEmployees;
        Sewer sewer = new Sewer(newId, name, skills);
        employeeMap.put(name, newId);
        return sewer;
    }

    public TeamResponsible hireTeamResponsible(String name, Team team) {
        int newId = ++numberOfEmployees;
        TeamResponsible teamResponsible = new TeamResponsible(newId, name, team);
        employeeMap.put(name, newId);
        return teamResponsible;
    }

    public void printEmployees() {
        employeeMap.forEach((name, id) -> System.out.println(STR."Employee name: \{name}, and id \{id}"));
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}