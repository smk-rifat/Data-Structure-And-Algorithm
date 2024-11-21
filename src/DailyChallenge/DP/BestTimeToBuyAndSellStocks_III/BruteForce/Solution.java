package DailyChallenge.DP.BestTimeToBuyAndSellStocks_III.BruteForce;
// https://www.youtube.com/watch?v=-uQGzhYj8BQ
class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        return bruteForce(prices, 0, 1, 2);
    }

    public int bruteForce(int[] prices, int idx, int buy, int transaction) {
        if (transaction == 0 || idx == n)
            return 0;
        
        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[idx] + bruteForce(prices, idx + 1, 0, transaction),
                    bruteForce(prices, idx + 1, 1, transaction));
        } else {
            profit = Math.max(prices[idx] + bruteForce(prices, idx + 1, 1, transaction - 1),
                    bruteForce(prices, idx + 1, 0, transaction));
        }

        return profit;
    }
}
