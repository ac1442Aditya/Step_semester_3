package control_flow.assigment_problems;

public class VotingEligibilityChecker {

    // Checks whether a student is old enough to vote
    static void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;

        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        checkVotingEligibility(20); // Eligible to vote
        checkVotingEligibility(16); // Not eligible to vote
    }
}
