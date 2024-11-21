package DailyChallenge.DP.CoinChangeII.BruteForce;
//https://leetcode.com/problems/coin-change-ii/
class Solution {
    public int change(int amount, int[] coins) {
        return recursive(coins, amount, 0);
    }
    public int recursive(int[] coins, int amount, int idx){
        if(amount == 0) return 1;
        if (amount < 0 || idx >= coins.length) return 0;

        int take = recursive(coins, amount - coins[idx], idx);
        int skip = recursive(coins, amount, idx+1);

        return take + skip;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        Solution obj = new Solution();
        System.out.println(obj.change(amount, coins));
    }
}