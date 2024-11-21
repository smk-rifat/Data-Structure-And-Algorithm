package DailyChallenge.DP.CoinChange.Memoization;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount +1];
        return memoization(coins, amount, memo);
    }
    public int memoization(int[] coins, int amount, Integer[] memo){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != null) return memo[amount];

        int minCoin = Integer.MAX_VALUE;

        for(int coin : coins){
            if(amount - coin < 0) continue;
            int search = memoization(coins, amount - coin, memo);

            if(search != -1 && search < minCoin){
                minCoin = 1 + search;
            }
        }

        memo[amount] = minCoin == Integer.MAX_VALUE ? -1 : minCoin;
        return memo[amount];
    }
}