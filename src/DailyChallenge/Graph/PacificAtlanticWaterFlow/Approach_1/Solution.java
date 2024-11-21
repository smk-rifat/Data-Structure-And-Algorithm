package DailyChallenge.Graph.PacificAtlanticWaterFlow.Approach_1;
//https://leetcode.com/problems/pacific-atlantic-water-flow/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int ROWS = heights.length;
        int COLS = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // calling dfs for top and bottom
        for (int r = 0; r < ROWS; r++) {
            dfs(heights,r, 0, Integer.MIN_VALUE, pacific);
            dfs(heights,r, COLS-1, Integer.MIN_VALUE, atlantic);
        }

        // calling dfs for left and right
        for (int c = 0; c < COLS; c++) {
            dfs(heights, ROWS-1,c, Integer.MIN_VALUE, atlantic);
            dfs(heights, 0,c, Integer.MIN_VALUE, pacific);
        }

        // gets the intersection of two sets
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
               if (pacific[i][j] && atlantic[i][j]){
                   ans.add(List.of(i,j));
               }
            }
        }

        return ans;
    }

    public void dfs(int[][] height, int r, int c, int previous,  boolean[][] ocean){
        if (r < 0 || c < 0 || r == height.length || c == height[0].length || ocean[r][c]) return;
        if (height[r][c] < previous) return;

        ocean[r][c] = true;

        dfs(height, r+1, c, height[r][c], ocean);
        dfs(height, r-1, c, height[r][c], ocean);
        dfs(height, r, c+1, height[r][c], ocean);
        dfs(height, r, c-1, height[r][c], ocean);
    }
}
