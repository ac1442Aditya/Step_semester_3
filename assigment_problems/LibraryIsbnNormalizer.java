package string_manipulation.assigment_problems;

public class LibraryIsbnNormalizer {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return firstThree + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalogNumber = body.substring(4);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] YEAR: ").append(year)
                .append(" | CATALOG: ").append(catalogNumber);

        return display.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1)); // [PEN] YEAR: 2026 | CATALOG: 004251

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2)); // Invalid: publisher code must be 3 letters
    }
}
