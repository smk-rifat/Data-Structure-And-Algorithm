package DailyChallenge.DP.EditDistance.oneD;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int prevDiag = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = prevDiag;
                } else
                    dp[j] = 1+ Math.min(dp[j-1],Math.min(dp[j], prevDiag));
                prevDiag = temp;
            }
        }

        return dp[n];
    }
}