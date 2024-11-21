package DailyChallenge.DP.LongestPalindromicSubsequence.Dp.TwoD;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int len = Integer.MIN_VALUE;

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i <= n-L; i++) {
                int j = i+L-1;

                if (i == j){
                    dp[i][j] = 1;
                } else if (i+1 == j){
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2;
                    } else
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                } else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                len = Math.max(dp[i][j], len);
            }
        }
        return len;
    }
}