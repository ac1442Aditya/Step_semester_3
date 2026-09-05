package arrays_and_strings.class_problems;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] nameChars = customerName.toCharArray();
        char[] reversedChars = new char[nameChars.length];

        for (int i = 0; i < nameChars.length; i++) {
            reversedChars[i] = nameChars[nameChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
