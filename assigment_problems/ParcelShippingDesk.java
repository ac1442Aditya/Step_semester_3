import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// only some parcels can be insured, so that ability is its own interface
interface Insurable {
    double INSURANCE_RATE = 0.02;

    double insurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract String getType();

    abstract double shippingCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    String getType() {
        return "STANDARD";
    }

    double shippingCharge() {
        return 40 + 10 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    String getType() {
        return "EXPRESS";
    }

    double shippingCharge() {
        return 80 + 15 * weightKg;
    }

    public double insurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    String getType() {
        return "FRAGILE";
    }

    double shippingCharge() {
        return (40 + 10 * weightKg) + 50;
    }

    public double insurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

public class ParcelShippingDesk {

    static Parcel create(String type, double weight, double value) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, value);
            case "EXPRESS":
                return new ExpressParcel(weight, value);
            default:
                return new FragileParcel(weight, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            parcels.add(create(p[0], Double.parseDouble(p[1]), Double.parseDouble(p[2])));
        }

        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.shippingCharge();
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance();
            }
            double total = charge + insurance;
            System.out.println(String.format(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f",
                    parcel.getType(), charge, insurance, total));
            grandTotal += total;
        }
        System.out.println(String.format(Locale.US, "Grand Total: %.2f", grandTotal));
    }
}
