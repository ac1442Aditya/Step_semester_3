import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract String getType();

    abstract double parkingCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    String getType() {
        return "BIKE";
    }

    double parkingCharge() {
        return 10.0 * hours;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    String getType() {
        return "CAR";
    }

    double parkingCharge() {
        return 30.0 + 20.0 * (hours - 1);
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    String getType() {
        return "TRUCK";
    }

    double parkingCharge() {
        return Math.max(50.0 * hours, 100.0);
    }
}

public class CampusParkingCharge {

    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            default:
                return new Truck(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            vehicles.add(create(parts[0], Integer.parseInt(parts[1])));
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.parkingCharge();
            System.out.println(String.format(Locale.US, "%s: %.2f", v.getType(), charge));
            total += charge;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
