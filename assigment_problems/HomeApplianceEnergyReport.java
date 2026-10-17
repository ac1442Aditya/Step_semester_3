import java.util.Locale;
import java.util.Scanner;

// only some appliances have a saver mode
interface SaverMode {
    double SAVER_REDUCTION = 0.25;

    default double applySaver(double units) {
        return units * (1 - SAVER_REDUCTION);
    }
}

abstract class Appliance {
    private static final double COST_PER_UNIT = 8;

    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract String getName();

    abstract double powerWatts();

    double units() {
        return powerWatts() * hours / 1000;
    }

    static double cost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    String getName() {
        return "FRIDGE";
    }

    double powerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    String getName() {
        return "AC";
    }

    double powerWatts() {
        return 1500;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    String getName() {
        return "TV";
    }

    double powerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    String getName() {
        return "WASHER";
    }

    double powerWatts() {
        return 500;
    }
}

public class HomeApplianceEnergyReport {

    static Appliance create(String name, double hours) {
        switch (name) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AirConditioner(hours);
            case "TV":
                return new Television(hours);
            default:
                return new WashingMachine(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Appliance appliance = create(p[0], Double.parseDouble(p[1]));
            boolean saverRequested = p.length > 2 && p[2].equals("SAVER");

            double units = appliance.units();
            if (saverRequested) {
                if (appliance instanceof SaverMode) {
                    units = ((SaverMode) appliance).applySaver(units);
                } else {
                    System.out.println(appliance.getName() + ": saver mode not supported");
                    continue;
                }
            }
            double cost = Appliance.cost(units);
            System.out.println(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f", appliance.getName(), units, cost));
            totalCost += cost;
        }
        System.out.println(String.format(Locale.US, "Total Cost: %.2f", totalCost));
    }
}
