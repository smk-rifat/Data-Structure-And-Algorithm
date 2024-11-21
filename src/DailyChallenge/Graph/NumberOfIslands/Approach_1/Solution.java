package DailyChallenge.Graph.NumberOfIslands.Approach_1;
// https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int Row = grid.length;
        int Col = grid[0].length;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1'){
                    ans++;
                    dfs(grid, r, c, Row, Col);
                }
            }
        }

        return ans;
    }
    void dfs(char[][] grid, int r, int c, int Row, int Col){
        if (Math.min(r,c) < 0 || r == Row || c == Col || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(grid, r+1, c, Row, Col);
        dfs(grid, r-1, c, Row, Col);
        dfs(grid, r, c+1, Row, Col);
        dfs(grid, r, c-1, Row, Col);
    }
}