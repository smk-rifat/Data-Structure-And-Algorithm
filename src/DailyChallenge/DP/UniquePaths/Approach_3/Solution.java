package DailyChallenge.DP.UniquePaths.Approach_3;
import java.util.Arrays;
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[] path = new int[n];
        Arrays.fill(path, 1);

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                path[c] += path[c-1];
            }
        }

        return path[n-1];
    }
}