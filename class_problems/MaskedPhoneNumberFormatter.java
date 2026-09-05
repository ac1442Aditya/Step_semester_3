package string_manipulation.class_problems;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = phone.substring(6);

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append("-");
        masked.append(lastFourDigits);

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));       // Invalid phone number
    }
}
