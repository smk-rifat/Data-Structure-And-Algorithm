package DailyChallenge.DP.BestTimeToBuyAndSellStockwithCoolDown.Dp.SpaceOptimized;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // Arrays to store the maximum profit for the next day and the day after next
        int[] nextDay = new int[2];      // nextDay[0]: not holding stock, nextDay[1]: holding stock
        int[] nextNextDay = new int[2];  // Same as above but for the day after next
        int[] currentDay = new int[2];   // Current day's profit states

        // Traverse the prices array from the end to the beginning
        for (int day = n - 1; day >= 0; day--) {
            // Iterate through both states: 0 -> not holding stock, 1 -> holding stock
            for (int holding = 0; holding <= 1; holding++) {
                int profit;

                if (holding == 0) {
                    // We are not holding a stock
                    // Option 1: Do nothing, take the profit from the next day when not holding a stock
                    int doNothing = nextDay[0];
                    // Option 2: Buy a stock today, subtract the price, and take the profit from the next day when holding a stock
                    int buyStock = -prices[day] + nextDay[1];
                    // Choose the option that gives maximum profit
                    profit = Math.max(doNothing, buyStock);
                } else {
                    // We are holding a stock
                    // Option 1: Do nothing, take the profit from the next day when holding a stock
                    int doNothing = nextDay[1];
                    // Option 2: Sell the stock today, add the price, and take the profit from the day after next when not holding a stock (due to cooldown)
                    int sellStock = prices[day] + nextNextDay[0];
                    // Choose the option that gives maximum profit
                    profit = Math.max(doNothing, sellStock);
                }

                currentDay[holding] = profit;
            }

            // Update nextNextDay and nextDay for the next iteration
            nextNextDay = nextDay.clone();
            nextDay = currentDay.clone();
        }

        // The maximum profit is when we are not holding any stock on the first day
        return currentDay[0];
    }
}
