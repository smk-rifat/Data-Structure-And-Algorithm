package DailyChallenge.DP.InterleavingString.PureDp;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m+n) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = (s1.charAt(i-1) == s3.charAt(i-1)) && dp[i-1][0];
        }

        for (int j = 1; j <= n ; j++) {
            dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                boolean takeS1 = s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j];
                boolean takeS2 = s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1];

                dp[i][j] = takeS1 || takeS2;
            }
        }
        return dp[m][n];
    }
}