package DailyChallenge.DP.LongestPalindromicSubsequence.LCS_Approach.Dp_1;

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int n = s.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;  // Represents dp[j-1] from the previous iteration
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];  // Store the current dp[j] before updating it
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;  // Update prev to the current dp[j] for the next iteration
            }
        }

        return dp[n];
    }
}
