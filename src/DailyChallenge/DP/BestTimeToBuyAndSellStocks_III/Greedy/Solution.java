package DailyChallenge.DP.BestTimeToBuyAndSellStocks_III.Greedy;

// Solution for "Best Time to Buy and Sell Stock III" problem

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0; // If there are no prices, no profit can be made
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);

            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
        }

        return secondSell;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(obj.maxProfit(prices));
    }
}
