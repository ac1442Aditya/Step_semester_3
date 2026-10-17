class AttendanceSheet {
    private String[] present;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.present = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (count >= present.length) {
            System.out.println("Sheet is full, cannot mark " + name);
            return;
        }
        present[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class AttendanceSheetManagement {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
