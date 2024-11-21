package DailyChallenge.DP.BestTimeToBuyAndSellStocksII.Tabulation;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        int[] cur = new int[2];

        prev[0] = 0;
        prev[1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int profit = 0;

            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1)
                    profit = Math.max(-prices[i] + prev[0], prev[1]);
                else
                    profit = Math.max(prices[i] + prev[1], prev[0]);
                cur[buy] = profit;
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
       
        return prev[1];
    }
}
