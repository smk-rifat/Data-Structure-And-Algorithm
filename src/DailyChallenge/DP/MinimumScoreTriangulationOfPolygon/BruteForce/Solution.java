package DailyChallenge.DP.MinimumScoreTriangulationOfPolygon.BruteForce;
// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        return bruteForce(values, 0, n-1);
    }
    public int bruteForce(int[] val, int i, int j){
        if ((j - i +1 < 3) || i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k <= j-1 ; k++) {
            int cost = (val[i] * val[k] * val[j]) + bruteForce(val, i, k) + bruteForce(val, k, j);
            ans = Math.min(cost, ans);
        }
        return ans;
    }
}