import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class BorrowedItem {
    protected String title;
    protected int daysLate;

    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    String getTitle() {
        return title;
    }

    abstract double fine();
}

class BookItem extends BorrowedItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 2.0 * daysLate;
    }
}

class DvdItem extends BorrowedItem {
    DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(5.0 * daysLate, 50.0);
    }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 1.0 * daysLate;
    }
}

public class LibraryLateFineCounter {

    static BorrowedItem create(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DvdItem(title, daysLate);
            default:
                return new MagazineItem(title, daysLate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<BorrowedItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            items.add(create(p[0], p[1], Integer.parseInt(p[2])));
        }

        double total = 0;
        for (BorrowedItem item : items) {
            double fine = item.fine();
            System.out.println(String.format(Locale.US, "%s: %.2f", item.getTitle(), fine));
            total += fine;
        }
        System.out.println(String.format(Locale.US, "Total Fines: %.2f", total));
    }
}
