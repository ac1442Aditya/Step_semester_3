import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                continue;
            }

            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equalsIgnoreCase(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
    }
}
