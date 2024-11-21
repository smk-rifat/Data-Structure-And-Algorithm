package DailyChallenge.DP.BestTimeToBuyAndSellStock.Approach_2;

class Solution {
    public int maxProfit(int[] prices) {
        // if we want to sell on iTh day then we have to buy at minimum cost before iTh day means 1 to (i-1)th day
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i] - min;
            profit = Math.max(sell, profit);
            min = Math.min(prices[i], min);
        }
        return profit;
    }
}
