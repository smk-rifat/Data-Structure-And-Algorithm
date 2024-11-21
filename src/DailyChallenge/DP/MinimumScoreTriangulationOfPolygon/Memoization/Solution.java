package DailyChallenge.DP.MinimumScoreTriangulationOfPolygon.Memoization;

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] memo = new Integer[n][n];
        return bruteForce(values, 0, n-1, memo);
    }
    public int bruteForce(int[] val, int i, int j, Integer[][] memo){
        if(memo[i][j] != null) return memo[i][j];
        if ((j - i +1 < 3) || i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k <= j-1 ; k++) {
            int cost = (val[i] * val[k] * val[j]) + bruteForce(val, i, k,memo) + bruteForce(val, k, j, memo);
            ans = Math.min(cost, ans);
        }
        memo[i][j] = ans;
        return memo[i][j];
    }
}