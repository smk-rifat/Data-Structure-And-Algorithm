package DailyChallenge.DP.Nth_CatalanNumber.Memoization;

class Solution {
    public static int findCatalan(int n) {
        Integer[] memo = new Integer[n+1];
        return catalan(n, memo);
    }
    public static int catalan(int n, Integer[] memo){
        if(n == 1 || n == 0) return 1;
        if(memo[n] != null) return memo[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int left = catalan(i-1, memo);
            int right = catalan(n-i, memo);

            sum += left*right;
        }
        memo[n] = sum;
        return memo[n];
    }
}
