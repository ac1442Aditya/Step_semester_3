package arrays_and_strings.class_problems;

public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256]; // basic ASCII frequency count, no HashMap needed

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequency[c]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency[c] == 1) {
                return c;
            }
        }

        return '\0'; // no non-repeating character found
    }

    public static void main(String[] args) {
        printResult("swiss");
        printResult("aabbcc");
    }

    private static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }
}
