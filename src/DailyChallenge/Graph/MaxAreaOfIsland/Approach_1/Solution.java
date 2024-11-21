package DailyChallenge.Graph.MaxAreaOfIsland.Approach_1;
// https://leetcode.com/problems/max-area-of-island/
class Solution {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
         int R = grid.length;
         int C = grid[0].length;

         int maxArea = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1){
                    maxArea = Math.max(maxArea, maxArea(grid, i, j, R, C));
                }
            }
        }
        return maxArea;
    }
    static int maxArea(int[][] grid, int r, int c, int R, int C){
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == 0) return 0;
        int area = 1;

        area += maxArea(grid, r+1, c, R, C);
        area += maxArea(grid, r-1, c, R, C);
        area += maxArea(grid, r, c+1, R, C);
        area += maxArea(grid, r, c-1, R, C);

        return area;
    }


}