package DailyChallenge.DP.CoinChange.Recursive;
// https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
      return recursive(coins, amount, 0);
    }
   public int recursive (int[] coins, int amount, int coinCount){
        if (amount == 0) return coinCount;
        if (amount < 0) return -1;

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins){
            int search = recursive(coins, amount - coin, coinCount + 1);
            if (search != -1){
                minCount = Math.min(search, minCount);
            }
        }

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
   }

    public static void main(String[] args) {
        int[] coins = {1,3,4,5};
        int amount = 7;
        Solution obj = new Solution();
        System.out.println(obj.coinChange(coins, amount));
    }
}