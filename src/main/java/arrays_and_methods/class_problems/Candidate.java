package arrays_and_methods.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order by composite score -- higher score ranks first
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    // CGPA-only quick filter for a clearly strong candidate
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined filter for a borderline CGPA, backed up by a genuinely good coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate candidate : candidates) {
            boolean qualifies = isEligible(candidate.getCgpa())
                    || isEligible(candidate.getCgpa(), candidate.getCodingScore());

            if (qualifies) {
                shortlisted.add(candidate);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray); // uses compareTo above -- no separate comparator needed

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate candidate = shortlistedArray[i];
            result.append(i + 1).append(". ").append(candidate.getName())
                    .append(" (").append(String.format("%.1f", candidate.getCompositeScore())).append(")");

            if (i < shortlistedArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
