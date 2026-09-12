package arrays_and_methods.class_problems;

public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];

            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] topThree = findTopThreeScores(scores);
        System.out.println("[" + topThree[0] + ", " + topThree[1] + ", " + topThree[2] + "]");
        // [90, 90, 82]
    }
}
