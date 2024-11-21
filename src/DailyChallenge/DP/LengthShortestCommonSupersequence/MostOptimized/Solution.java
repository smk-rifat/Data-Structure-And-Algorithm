package DailyChallenge.DP.LengthShortestCommonSupersequence.MostOptimized;

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 0; j <= n; j++) {
                int current = dp[j];
                if (X.charAt(i-1) != Y.charAt(j-1))
                    dp[j]  = 1+ Math.min(dp[j], dp[j-1]);
                else
                    dp[j] = 1 + prev;
                prev = current;
            }
        }

        return dp[n];
    }
}