import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "CARD";
    }

    double finalAmount() {
        return amount + amount * 0.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "WALLET";
    }

    double finalAmount() {
        return amount + amount * 0.01;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "BANKTRANSFER";
    }

    double finalAmount() {
        return amount;
    }
}

public class PaymentFeeCalculation {

    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            default:
                return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            payments.add(create(parts[0], Double.parseDouble(parts[1])));
        }

        double total = 0;
        for (Payment p : payments) {
            double result = p.finalAmount();
            System.out.println(String.format(Locale.US, "%s: %.2f", p.getType(), result));
            total += result;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
