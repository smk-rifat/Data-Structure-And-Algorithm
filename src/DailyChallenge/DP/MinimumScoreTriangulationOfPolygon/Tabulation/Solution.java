package DailyChallenge.DP.MinimumScoreTriangulationOfPolygon.Tabulation;

class Solution {
    public int minScoreTriangulation(int[] val) {
        int n = val.length;
        int[][] dp = new int[n][n];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){

                if(j-i+1 < 3) continue;
                int ans = Integer.MAX_VALUE;
                for (int k = i+1; k <= j-1 ; k++) {
                    int cost = (val[i] * val[k] * val[j]) + dp[i][k] + dp[k][j];
                    ans = Math.min(cost, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }
}