import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Room {
    protected long units;

    Room(long units) {
        this.units = units;
    }

    abstract String getType();

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(long units) {
        super(units);
    }

    String getType() {
        return "SINGLE";
    }

    double calculateBill() {
        return 8.0 * units;
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(long units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    String getType() {
        return "SHARED";
    }

    double calculateBill() {
        return 6.0 * units / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(long units) {
        super(units);
    }

    String getType() {
        return "AC";
    }

    double calculateBill() {
        return 10.0 * units + 200;
    }
}

public class HostelElectricityBill {

    static Room create(String[] p) {
        long units = Long.parseLong(p[1]);
        switch (p[0]) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, Integer.parseInt(p[2]));
            default:
                return new AcRoom(units);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.println(String.format(Locale.US, "%s: %.2f", r.getType(), bill));
            total += bill;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
