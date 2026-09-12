package arrays_and_methods.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        // Descending order by batting average -- higher average ranks first
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Experience-only rule: an established player qualifies on matches played alone
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined rule: a newer player still needs to be reasonably experienced and currently fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> draftablePlayers = new ArrayList<>();

        for (Player player : players) {
            boolean qualifies = isDraftable(player.getMatchesPlayed())
                    || isDraftable(player.getMatchesPlayed(), player.isInjured());

            if (qualifies) {
                draftablePlayers.add(player);
            }
        }

        Player[] draftableArray = draftablePlayers.toArray(new Player[0]);
        Arrays.sort(draftableArray); // uses compareTo above -- no separate comparator needed

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].getName());

            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players)); // 1. Rahul | 2. Virat | 3. Dev
    }
}
