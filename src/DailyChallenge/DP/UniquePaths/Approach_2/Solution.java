package DailyChallenge.DP.UniquePaths.Approach_2;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return helper(0,0,m,n,memo);
    }
    public int helper(int r, int c, int row, int col, int[][] memo){
        if (r == row || c == col) return 0;
        if (r == row -1 && c == col -1) return 1;

        if (memo[r][c] != -1) return memo[r][c];

        int right = helper(r, c+1, row, col, memo);
        int down = helper(r+1, c, row, col, memo);

        memo[r][c] = right + down;

        return memo[r][c];
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        Solution obj = new Solution();
        System.out.println(obj.uniquePaths(m,n));
    }
}