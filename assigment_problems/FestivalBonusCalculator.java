import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    String getName() {
        return name;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            default:
                return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            employees.add(create(parts[0], parts[1], Double.parseDouble(parts[2])));
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.println(String.format(Locale.US, "%s: %.2f", e.getName(), bonus));
            total += bonus;
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
    }
}
