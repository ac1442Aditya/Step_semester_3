package control_flow.assigment_problems;

public class NumberClassifier {

    // Labels a number as Positive, Negative, or Zero
    static void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        classifyNumber(15); // Positive
        classifyNumber(-4); // Negative
        classifyNumber(0);  // Zero
    }
}
