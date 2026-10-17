class Scorecard {
    private final int totalQuestions;
    private boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded >= totalQuestions) {
            System.out.println("Answer ignored: all " + totalQuestions + " questions already recorded");
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class QuizScorecardManagement {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());

        // fifth answer goes beyond the fixed question count
        sc.recordAnswer(true);
        System.out.println("Score after extra answer: " + sc.getScore());
    }
}
