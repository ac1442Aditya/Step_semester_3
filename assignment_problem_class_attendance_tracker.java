
public class assignment_problem_class_attendance_tracker {

    // returns {presentDays, longestStreak}
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    static void printSummary(int[] days) {
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }

    public static void main(String[] args) {
        printSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        printSummary(new int[]{0, 0, 0});
    }
}
