/*
 * Problem 6: Class Attendance Tracker
 *
 * Approach: walk through the days once. Every 1 adds to the present total and
 * extends the current streak; every 0 resets the streak to zero. The longest
 * streak is the largest value the running streak ever reaches.
 *
 * Complexity:
 *   Time  - O(n), a single pass.
 *   Space - O(1), three counters.
 *
 * Both answers come out of the same single pass, so there is no need to loop
 * over the array twice.
 */
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
