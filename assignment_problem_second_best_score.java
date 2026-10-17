/*
 * Problem 7: Second-Best Score
 *
 * Approach: visit every score once, keeping the highest and the second-highest
 * distinct score seen so far. A score equal to the current highest is skipped.
 *
 * Complexity:
 *   Time  - O(n), one pass over the array.
 *   Space - O(1), only two extra variables.
 *
 * Compared with sorting first:
 *   Sorting costs O(n log n) time, and it either changes the original array or
 *   needs O(n) extra space for a copy. After sorting you would still have to
 *   walk back past duplicates to find the second distinct value. The single
 *   pass is faster and does not touch the input.
 */
public class assignment_problem_second_best_score {

    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score != highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] sample1 = {45, 78, 92, 78, 60};
        int[] sample2 = {50, 50, 50};

        System.out.println(secondHighest(sample1));
        System.out.println(secondHighest(sample2));
    }
}
