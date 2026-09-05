package arrays_and_strings.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        int longestLength = 1;
        char longestColor = signalLog.charAt(0);

        int currentLength = 1;
        char currentColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);

            if (c == currentColor) {
                currentLength++;
            } else {
                currentColor = c;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Longest Streak: 'R' repeated 4 times
    }
}
