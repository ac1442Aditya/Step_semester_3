
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
