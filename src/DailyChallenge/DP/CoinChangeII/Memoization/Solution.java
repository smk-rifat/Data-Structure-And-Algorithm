package DailyChallenge.DP.CoinChangeII.Memoization;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] memo = new Integer[n+1][amount+1];
        return memoization(amount, coins, memo, 0);
    }
    public int memoization(int amount, int[] coins, Integer[][] memo, int idx){
        if (amount == 0) return 1;
        if (amount < 0 || idx >= coins.length) return 0;

        if (memo[idx][amount] != null) return memo[idx][amount];

        int take = memoization(amount - coins[idx], coins, memo, idx);
        int skip = memoization(amount, coins, memo, idx+1);

        memo[idx][amount] = skip+take;
        return memo[idx][amount];
    }
}