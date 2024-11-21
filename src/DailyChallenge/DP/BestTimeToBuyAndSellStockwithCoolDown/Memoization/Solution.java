package DailyChallenge.DP.BestTimeToBuyAndSellStockwithCoolDown.Memoization;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n+1][2];
        return bruteForce(prices, 0, 0, memo);
    }
    public int bruteForce(int[] prices,int day, int state, Integer[][] memo){
        if (day >= prices.length) return 0;
        if (memo[day][state] != null) return memo[day][state];
        int profit = 0;
        if (state == 0){
            int buy = bruteForce(prices, day+1, 1, memo) - prices[day];
            int skip = bruteForce(prices, day+1, 0, memo);
            profit = Math.max(buy, skip);
        } else {
            int sell = bruteForce(prices, day+2, 0, memo) + prices[day];
            int hold = bruteForce(prices, day+1,1, memo);
            profit = Math.max(sell, hold);
        }
        return memo[day][state] = profit;
    }
}