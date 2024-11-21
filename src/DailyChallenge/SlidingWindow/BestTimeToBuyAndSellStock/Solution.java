package DailyChallenge.SlidingWindow.BestTimeToBuyAndSellStock;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public static void main(String[] args) {
       int[] prices = {7,1,5,3,6,4};
       int ans = maxProfit(prices);
        System.out.println(ans);
    }
    public static  int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int right = 1;
        int profit = 0;

        while(right < n){
            if (prices[right] < prices[left]){
                left = right;
            } else if (prices[right] > prices[left]){
                profit = Math.max(profit, prices[right]-prices[left]);
            }
            right++;
        }
        return profit;
        // use two pointer approach, time complexity O(n)
    }
}