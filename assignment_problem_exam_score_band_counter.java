/*
 * Problem 4: Exam Score Band Counter
 *
 * Approach: the array is sorted, so the scores inside [low, high] form one
 * continuous block. Binary search finds where that block starts and where it
 * ends, and the answer is the difference of the two positions.
 *   start = first index with score >= low
 *   end   = first index with score >  high   (same as first index >= high + 1)
 *
 * Complexity:
 *   Linear scan    - O(n) time, O(1) space, and it repeats for every query.
 *   Binary search  - O(log n) time per query, O(1) space.
 *
 * Duplicates at the edges:
 *   A normal binary search stops at any element that matches, but with repeated
 *   marks that element could be anywhere inside a run of equal values (for
 *   example one of the three 58s). Counting from there would give a wrong
 *   answer. So the search is written to keep going after a match: it always
 *   moves towards the first position that satisfies the condition, which lands
 *   on the left edge of a run of duplicates.
 */
public class assignment_problem_exam_score_band_counter {

    // first index whose value is >= target (returns length if there is none)
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = firstAtLeast(scores, low);
        int end = firstAtLeast(scores, high + 1);
        return end - start;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
