package DailyChallenge.DP.UniqueBinarySearchTrees.Memoization;

class Solution {
    public int numTrees(int n) {
        Integer[] memo = new Integer[n+1];
        return helper(n, memo);
    }
    public int helper(int n, Integer[] memo){
        if(n == 1 || n == 0) return 1;
        if (memo[n] != null) return memo[n];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = helper(i-1, memo);
            int right = helper(n-i, memo);
            count += (left * right);
        }
        memo[n] = count;
        return memo[n];
    }
}