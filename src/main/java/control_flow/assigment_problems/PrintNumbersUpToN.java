package control_flow.assigment_problems;

public class PrintNumbersUpToN {

    // Prints every number from 1 up to n
    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printNumbersUpToN(5); // prints 1 2 3 4 5
    }
}
