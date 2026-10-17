import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOddCounter {

    // turns "[3, 8, 12]" into a list of integers
    static List<Integer> parseList(String line) {
        String cleaned = line.replace("[", "").replace("]", "").trim();
        List<Integer> numbers = new ArrayList<>();
        if (cleaned.isEmpty()) {
            return numbers;
        }
        for (String part : cleaned.split(",")) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = parseList(sc.nextLine());

        int even = 0;
        int odd = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
