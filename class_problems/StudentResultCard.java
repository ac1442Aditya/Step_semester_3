import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    char assignGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResultCard() {
        System.out.println(name.toUpperCase() + ": Average "
                + String.format("%.1f", calculateAverage()) + ", Grade " + assignGrade());
    }
}

public class StudentResultCard {

    // reads a line like: Asha [80, 90, 70]
    static Student parseStudent(String line) {
        int bracket = line.indexOf('[');
        String name = line.substring(0, bracket).trim();
        String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");

        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            marks[i] = Integer.parseInt(parts[i].trim());
        }
        return new Student(name, marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            parseStudent(line).printResultCard();
        }
    }
}
