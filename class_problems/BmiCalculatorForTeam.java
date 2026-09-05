package arrays_and_strings.class_problems;

import java.util.Random;

public class BmiCalculatorForTeam {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %d | %.2f | %.2f | %.2f | %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int teamSize = 10;

        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.4; // random height between 1.50m and 1.90m
            weights[i] = 50 + random.nextDouble() * 50;    // random weight between 50kg and 100kg
        }

        printWellnessReport(heights, weights);
    }
}
