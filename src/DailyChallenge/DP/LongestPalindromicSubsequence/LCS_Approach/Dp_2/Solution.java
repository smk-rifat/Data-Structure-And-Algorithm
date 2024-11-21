package DailyChallenge.DP.LongestPalindromicSubsequence.LCS_Approach.Dp_2;

class Solution {
    public int longestPalindromeSubseq(String a) {
        int n = a.length();
        StringBuilder sb = new StringBuilder(a);
        String b = sb.reverse().toString();

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][n];
    }
}