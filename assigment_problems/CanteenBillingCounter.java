import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    String getType() {
        return "STUDENT";
    }

    double finalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    String getType() {
        return "STAFF";
    }

    double finalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    String getType() {
        return "GUEST";
    }

    double finalAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {

    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            default:
                return new Guest(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            bills.add(create(parts[0], Double.parseDouble(parts[1])));
        }

        double total = 0;
        for (Customer c : bills) {
            double result = c.finalAmount();
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), result));
            total += result;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
