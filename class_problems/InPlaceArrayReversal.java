import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {

    static int[] parseArray(String line) {
        String cleaned = line.replace("[", "").replace("]", "").trim();
        if (cleaned.isEmpty()) {
            return new int[0];
        }
        String[] parts = cleaned.split(",");
        int[] tokens = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            tokens[i] = Integer.parseInt(parts[i].trim());
        }
        return tokens;
    }

    // two pointers swap towards the centre, no second array needed
    static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tokens = parseArray(sc.nextLine());

        reverseInPlace(tokens);

        System.out.println(Arrays.toString(tokens));
    }
}
