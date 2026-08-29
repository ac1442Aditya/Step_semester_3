package control_flow.assigment_problems;

public class SumOfNaturalNumbers {

    // Adds up every natural number from 1 to n using a while loop
    static void sumOfNaturalNumbers(int n) {
        int counter = 1;
        int sum = 0;

        while (counter <= n) {
            sum = sum + counter;
            counter++;
        }

        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        sumOfNaturalNumbers(5); // Sum of numbers from 1 to 5 = 15
    }
}
