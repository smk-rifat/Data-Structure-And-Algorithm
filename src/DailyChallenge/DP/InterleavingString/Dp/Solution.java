package DailyChallenge.DP.InterleavingString.Dp;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Check if the length of s3 is the sum of lengths of s1 and s2
        if (s3.length() != s1.length() + s2.length()) return false;

        // Initialize the 3D DailyChallenge.DP table
        boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        // Base case: empty strings match
        dp[0][0][0] = true;

        // Initialize the DailyChallenge.DP table for the case when s3 is formed by s1 alone
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0][i] = dp[i - 1][0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Initialize the DailyChallenge.DP table for the case when s3 is formed by s2 alone
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j][j] = dp[0][j - 1][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the DailyChallenge.DP table for all other cases
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                for (int k = 1; k <= s3.length(); k++) {

                    if ( s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i][j][k] || dp[i - 1][j][k - 1];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i][j][k] || dp[i][j - 1][k - 1];
                    }
                }
            }
        }

        return dp[s1.length()][s2.length()][s3.length()];
    }

}
