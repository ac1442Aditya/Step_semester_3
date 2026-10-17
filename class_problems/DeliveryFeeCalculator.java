import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract String getType();

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "STANDARD";
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "EXPRESS";
    }

    double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }

    double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFeeCalculator {

    static Delivery create(String[] p) {
        double weight = Double.parseDouble(p[1]);
        double distance = Double.parseDouble(p[2]);
        switch (p[0]) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            default:
                return new InternationalDelivery(weight, distance, Double.parseDouble(p[3]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deliveries.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.println(String.format(Locale.US, "%s: %.2f", d.getType(), fee));
            total += fee;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
