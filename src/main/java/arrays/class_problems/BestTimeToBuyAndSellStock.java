package arrays.class_problems;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int lowestPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestPriceSoFar;

            if (profitIfSoldToday > maxProfit) {
                maxProfit = profitIfSoldToday;
            }

            if (prices[i] < lowestPriceSoFar) {
                lowestPriceSoFar = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // 0
    }
}
