import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Connection {
    protected double units;

    Connection(double units) {
        this.units = units;
    }

    abstract String getType();

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super(units);
    }

    String getType() {
        return "HOME";
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super(units);
    }

    String getType() {
        return "SHOP";
    }

    double calculateBill() {
        return units * 8 + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super(units);
    }

    String getType() {
        return "FACTORY";
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {

    static Connection create(String type, double units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            default:
                return new FactoryConnection(units);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            connections.add(create(p[0], Double.parseDouble(p[1])));
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), bill));
            total += bill;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
