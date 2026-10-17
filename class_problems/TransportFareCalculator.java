import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Journey {
    protected double distance;

    Journey(double distance) {
        this.distance = distance;
    }

    abstract String getType();

    abstract double calculateFare();
}

class BusJourney extends Journey {
    BusJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "BUS";
    }

    double calculateFare() {
        double fare = 2 + 0.10 * distance;
        return Math.min(fare, 10);
    }
}

class TrainJourney extends Journey {
    TrainJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "TRAIN";
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    String getType() {
        return "METRO";
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class TransportFareCalculator {

    static Journey create(String[] p) {
        double distance = Double.parseDouble(p[1]);
        switch (p[0]) {
            case "BUS":
                return new BusJourney(distance);
            case "TRAIN":
                return new TrainJourney(distance);
            default:
                return new MetroJourney(distance, Double.parseDouble(p[2]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            journeys.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            System.out.println(String.format(Locale.US, "%s: %.2f", j.getType(), fare));
            total += fare;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
