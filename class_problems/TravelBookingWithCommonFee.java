import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Booking {
    // the booking fee lives here and nowhere else
    private static final double BOOKING_FEE = 50;

    protected double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract String getMode();

    abstract double baseFare();

    final double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    String getMode() {
        return "BUS";
    }

    double baseFare() {
        return 2 * distanceKm;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    String getMode() {
        return "TRAIN";
    }

    double baseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    String getMode() {
        return "FLIGHT";
    }

    double baseFare() {
        return 2500 + 4 * distanceKm;
    }
}

public class TravelBookingWithCommonFee {

    static Booking create(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            default:
                return new FlightBooking(distanceKm);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            bookings.add(create(p[0], Double.parseDouble(p[1])));
        }

        for (Booking b : bookings) {
            System.out.println(String.format(Locale.US, "%s: %.2f", b.getMode(), b.totalFare()));
        }
    }
}
