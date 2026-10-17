import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// a plain "ticket" can never be sold, so the base class is abstract
abstract class Ticket {
    // the convenience fee is written in one place only
    private static final double CONVENIENCE_FEE = 20;

    protected int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract String getSeatType();

    abstract double pricePerTicket();

    final double amount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    String getSeatType() {
        return "REGULAR";
    }

    double pricePerTicket() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    String getSeatType() {
        return "PREMIUM";
    }

    double pricePerTicket() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    String getSeatType() {
        return "RECLINER";
    }

    double pricePerTicket() {
        return 400;
    }
}

public class MovieTicketCounter {

    static Ticket create(String seat, int count) {
        switch (seat) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            default:
                return new ReclinerTicket(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            bookings.add(create(p[0], Integer.parseInt(p[1])));
        }

        double total = 0;
        for (Ticket t : bookings) {
            double amount = t.amount();
            System.out.println(String.format(Locale.US, "%s: %.2f", t.getSeatType(), amount));
            total += amount;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
