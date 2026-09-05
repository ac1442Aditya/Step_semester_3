package arrays_and_strings.class_problems;

public class PalindromeCheckerThreeApproaches {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        char first = text.charAt(0);
        char last = text.charAt(text.length() - 1);

        if (first != last) {
            return false;
        }

        String middle = text.substring(1, text.length() - 1);
        return isPalindromeRecursive(middle);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedText = new String(reversed);
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        printResults("madam");
        printResults("hello");
    }

    private static void printResults(String text) {
        String iterativeResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recursiveResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterativeResult + " | Recursive: " + recursiveResult
                + " | Array Reversal: " + arrayResult);
    }
}
