package string_manipulation.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (isStopWord(word, stopWords)) {
                continue;
            }

            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Simple selection-based sort by count, descending (no streams)
        String[] uniqueWords = frequency.keySet().toArray(new String[0]);

        for (int i = 0; i < uniqueWords.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < uniqueWords.length; j++) {
                if (frequency.get(uniqueWords[j]) > frequency.get(uniqueWords[maxIndex])) {
                    maxIndex = j;
                }
            }
            String temp = uniqueWords[i];
            uniqueWords[i] = uniqueWords[maxIndex];
            uniqueWords[maxIndex] = temp;
        }

        for (String word : uniqueWords) {
            System.out.println(word + ": " + frequency.get(word));
        }
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
    }
}
