package string_manipulation.class_problems;

public class BankTransactionReferenceGenerator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();

        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return firstThree + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String day = body.substring(0, 2);
        String month = body.substring(2, 4);
        String year = body.substring(4, 6);
        String sequence = body.substring(6);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] DATE: ")
                .append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(sequence);

        return display.toString();
    }

    public static void main(String[] args) {
        String reference1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(reference1)); // [HDF] DATE: 03/02/26 | SEQ: 00042

        String reference2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(reference2)); // Invalid: bank code must be 3 letters
    }
}
