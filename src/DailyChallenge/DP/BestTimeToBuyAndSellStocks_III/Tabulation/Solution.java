package DailyChallenge.DP.BestTimeToBuyAndSellStocks_III.Tabulation;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];
        int[][] cur = new int[2][3];


        // base case
        for (int buy = 0; buy < 2; buy++) {
            for (int transaction = 0; transaction < 3; transaction++) {
                prev[buy][transaction] = 0; // No profit if beyond the last day
            }
        }

        for (int idx = n-1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int transaction = 1; transaction < 3; transaction++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-prices[idx] + prev[0][transaction],
                                prev[1][transaction]);
                    else
                        profit = Math.max(prices[idx] + prev[1][transaction - 1],
                                prev[0][transaction]);

                    cur[buy][transaction] = profit;
                }
            }
            int[][] temp = cur;
            cur = prev;
            prev = temp;
        }
        return prev[1][2];
    }
}
