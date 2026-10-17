import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    String getOwner() {
        return owner;
    }

    abstract String getShape();

    abstract double area();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    String getShape() {
        return "CIRCLE";
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    String getShape() {
        return "RECTANGLE";
    }

    double area() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    String getShape() {
        return "TRIANGLE";
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {

    static Plot create(String[] p) {
        switch (p[0]) {
            case "CIRCLE":
                return new CirclePlot(p[1], Double.parseDouble(p[2]));
            case "RECTANGLE":
                return new RectanglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
            default:
                return new TrianglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plots.add(create(sc.nextLine().trim().split("\\s+")));
        }

        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            System.out.println(String.format(Locale.US, "%s (%s): %.2f", plot.getOwner(), plot.getShape(), area));
            total += area;
        }
        System.out.println(String.format(Locale.US, "Total Area: %.2f", total));
    }
}
