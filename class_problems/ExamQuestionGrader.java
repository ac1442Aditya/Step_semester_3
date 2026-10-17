import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract String getType();

    abstract double evaluate();
}

class McqQuestion extends Question {
    McqQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() {
        return "MCQ";
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() {
        return "TF";
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    String getType() {
        return "ESSAY";
    }

    double evaluate() {
        String answer = studentAnswer.toLowerCase();
        int matched = 0;
        for (String keyword : correctAnswer.split(",")) {
            String k = keyword.trim().toLowerCase();
            if (!k.isEmpty() && answer.contains(k)) {
                matched++;
            }
        }
        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class ExamQuestionGrader {

    // splits a line into quoted strings and plain words
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) {
            tokens.add(m.group(1) != null ? m.group(1) : m.group(2));
        }
        return tokens;
    }

    static Question create(List<String> t) {
        int points = Integer.parseInt(t.get(4));
        switch (t.get(0)) {
            case "MCQ":
                return new McqQuestion(t.get(1), t.get(2), t.get(3), points);
            case "TF":
                return new TrueFalseQuestion(t.get(1), t.get(2), t.get(3), points);
            default:
                return new EssayQuestion(t.get(1), t.get(2), t.get(3), points);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(create(tokenize(sc.nextLine().trim())));
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.evaluate();
            System.out.println(String.format(Locale.US, "%s: %.2f", q.getType(), score));
            total += score;
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}
