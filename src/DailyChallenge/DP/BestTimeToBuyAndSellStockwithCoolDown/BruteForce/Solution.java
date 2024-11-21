package DailyChallenge.DP.BestTimeToBuyAndSellStockwithCoolDown.BruteForce;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

class Solution {
    public int maxProfit(int[] prices) {
        return bruteForce(prices, 0, 0);
    }
    public int bruteForce(int[] prices,int day, int state){
       if (day >= prices.length) return 0;
       int profit = 0;
       if (state == 0){
           int buy = bruteForce(prices, day+1, 1) - prices[day];
           int skip = bruteForce(prices, day+1, 0);
           profit = Math.max(buy, skip);
       } else {
           int sell = bruteForce(prices, day+2, 0) + prices[day];
           int hold = bruteForce(prices, day+1,1);
           profit = Math.max(sell, hold);
       }
       return profit;
    }
}
