package arrays_and_strings.assigment_problems;

public class SeatDuplicationChecker {

    // Compares every seat number against every other one -- arrays and loops only, no Collections
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats1); // Duplicate Seat Number Found: 102

        int[] seats2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seats2); // No Duplicate Seats Found
    }
}
