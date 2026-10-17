import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    String getName() {
        return name;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {

    static Plan create(String type, String name, LocalDate start) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, start);
            case "STANDARD":
                return new StandardPlan(name, start);
            default:
                return new PremiumPlan(name, start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Plan> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            subscribers.add(create(parts[0], parts[1], LocalDate.parse(parts[2])));
        }

        for (Plan p : subscribers) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}
