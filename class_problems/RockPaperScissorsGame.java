package arrays_and_strings.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // predefined for a live demo

        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");

        for (int round = 1; round <= playerMoves.length; round++) {
            String playerMove = playerMoves[round - 1];
            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            System.out.println(round + " | " + playerMove + " | " + computerMove + " | " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;

        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");
    }
}
