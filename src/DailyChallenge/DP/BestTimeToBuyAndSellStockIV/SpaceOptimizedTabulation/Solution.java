package DailyChallenge.DP.BestTimeToBuyAndSellStockIV.SpaceOptimizedTabulation;

class Solution {
    public int maxProfit(int transaction, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][transaction + 1];
        int[][] cur = new int[2][transaction + 1];

        for (int buy = 0; buy < 2; buy++) {
            for (int k = 0; k <= transaction; k++) {
                prev[buy][k] = 0;
            }
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <= transaction; k++) {

                    int profit = 0;

                    if (buy == 1)
                        profit = Math.max(-prices[idx] + prev[0][k],
                                prev[1][k]);
                    else
                        profit = Math.max(prices[idx] + prev[1][k - 1],
                                prev[0][k]);
                    cur[buy][k] = profit;
                }
            }
            int[][] temp = cur;
            cur = prev;
            prev = temp;
        }

        return prev[1][transaction];
    }
}
