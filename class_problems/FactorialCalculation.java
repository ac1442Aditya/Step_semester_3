import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculation {

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;   // also covers 0! = 1
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(factorial(n));
        }
    }
}
