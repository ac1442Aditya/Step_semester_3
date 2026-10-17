import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// only some students use the college bus
interface UsesBus {
    // the transport fee is written in one place only
    double TRANSPORT_FEE = 12000;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();
        if (this instanceof UsesBus) {
            fee += ((UsesBus) this).transportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements UsesBus {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements UsesBus {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuition() {
        return 40000 / 2.0;
    }
}

public class CollegeFeeCounter {

    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            default:
                return new ScholarshipStudent(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            students.add(create(p[0], p[1]));
        }

        double total = 0;
        for (Student s : students) {
            double fee = s.totalFee();
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), fee));
            total += fee;
        }
        System.out.println(String.format(Locale.US, "Total Collected: %.2f", total));
    }
}
