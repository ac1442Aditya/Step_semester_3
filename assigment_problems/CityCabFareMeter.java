import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// only sedans and SUVs can run at night
interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    default double nightFare(double dayFare) {
        return dayFare * (1 + NIGHT_SURCHARGE);
    }
}

abstract class Cab {
    // the minimum fare rule is shared by every cab
    private static final double MINIMUM_FARE = 100;

    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract String getType();

    abstract double ratePerKm();

    final double dayFare() {
        return Math.max(km * ratePerKm(), MINIMUM_FARE);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    String getType() {
        return "MINI";
    }

    double ratePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    String getType() {
        return "SEDAN";
    }

    double ratePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) {
        super(km);
    }

    String getType() {
        return "SUV";
    }

    double ratePerKm() {
        return 18;
    }
}

public class CityCabFareMeter {

    static Cab create(String type, double km) {
        switch (type) {
            case "MINI":
                return new MiniCab(km);
            case "SEDAN":
                return new SedanCab(km);
            default:
                return new SuvCab(km);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Cab cab = create(p[0], Double.parseDouble(p[1]));
            boolean night = p[2].equals("NIGHT");

            double fare = cab.dayFare();
            if (night) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).nightFare(fare);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                    continue;
                }
            }
            System.out.println(String.format(Locale.US, "%s: %.2f", cab.getType(), fare));
            total += fare;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
