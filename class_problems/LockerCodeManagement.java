class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            System.out.println("Change rejected: wrong current code");
            return false;
        }
        code = newCode;
        System.out.println("Code changed successfully");
        return true;
    }

    // used only for the demo check, no way to read the code itself
    public boolean isCode(String attempt) {
        return code.equals(attempt);
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerCodeManagement {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");

        System.out.println("Code is still 5678: " + l.isCode("5678"));
        System.out.println("Code is 9999: " + l.isCode("9999"));
    }
}
