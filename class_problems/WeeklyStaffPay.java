import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double weeklyPay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double weeklyPay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double weeklyPay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double weeklyPay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    static Staff create(String[] p) {
        switch (p[0]) {
            case "FULLTIME":
                return new FullTimeStaff(p[1], Double.parseDouble(p[2]));
            case "HOURLY":
                return new HourlyStaff(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
            default:
                return new InternStaff(p[1], Double.parseDouble(p[2]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            staff.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Staff s : staff) {
            double pay = s.weeklyPay();
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), pay));
            total += pay;
        }
        System.out.println(String.format(Locale.US, "Total Payroll: %.2f", total));
    }
}
