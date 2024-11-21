package DailyChallenge.DP.UniquePaths_II.Approach_1;
// https://leetcode.com/problems/unique-paths-ii/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[] path = new int[col];
        path[0] = 1;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (obstacleGrid[r][c] == 1){
                    path[c] = 0;
                } else if (c > 0){
                    path[c] += path[c-1];
                }
            }
        }
        return path[col-1];
    }
}