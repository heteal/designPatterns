package org.example;
import java.util.List;

/**
 *  Sewers act as observers for incoming orders, uses a behavioral pattern, observer
 */
public class Sewer extends Employee{


    private boolean isAvailable = true;
    private final List<ProductCatalog.Products> skills;

    public Sewer(int employeeId, String name, List<ProductCatalog.Products> skills) {
        super(employeeId, name);
        this.skills = skills;
    }

    public void accept(SewerVisitor visitor) {
        visitor.visitStatus(this);
    }

    public synchronized void notifyMe(Order order) {
        if (!isAvailable) {
            System.out.println(STR."\{getName()} (ID: \{getEmployeeId()}) is busy, skipping...");
            return;
        }

        if (!skills.contains(order.getProduct())) {
            System.out.println(STR."\{getName()} (ID: \{getEmployeeId()}) cannot sew \{order.getProduct()} because it's not in their skill set.");
            return;
        }

        isAvailable = false;
        System.out.println(STR."\{getName()} (ID: \{getEmployeeId()}) is sewing: \{order}");

        new Thread(() -> {
            try {
                long sewingTime = order.getProduct().getSewingTimeInMillis();
                Thread.sleep(sewingTime);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                synchronized (this) {
                    isAvailable = true;
                    System.out.println(STR."\{getName()} (ID: \{getEmployeeId()}) finished sewing: \{order}");
                    notifyAll();
                }
            }
        }).start();
    }

    public List<ProductCatalog.Products> getSkills() {
        return skills;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }
}