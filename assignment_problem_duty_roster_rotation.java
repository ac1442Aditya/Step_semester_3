import java.util.Arrays;

/*
 * Problem 8: Duty Roster Rotation
 *
 * Approach: rotating by k is the same as rotating by k % n, because n
 * rotations bring the roster back to where it started. Then every name at
 * index i simply moves to index (i + k) % n in a new array.
 *
 * Complexity:
 *   Time  - O(n), each name is placed once.
 *   Space - O(n) for the new roster.
 *
 * Why moving one place at a time, k times, is slow:
 *   Each single-place rotation touches all n names, so the total work is
 *   O(n * k). With k up to 10^9 and n up to 100 that is around 10^11 steps,
 *   most of them wasted on full turns that change nothing. Using k % n first
 *   reduces the work to a single pass no matter how large k is.
 */
public class assignment_problem_duty_roster_rotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
