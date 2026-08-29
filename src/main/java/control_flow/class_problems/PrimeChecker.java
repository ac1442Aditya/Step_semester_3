package control_flow.class_problems;

import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break; // factor found, no need to keep checking
            }
        }

        System.out.println("Is the number " + number + " a Prime number? " + isPrime);

        sc.close();
    }
}
