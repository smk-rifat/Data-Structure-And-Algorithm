package DailyChallenge.DP.UniquePaths.Approach_1;
// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        return bruteForce(0, 0, m, n);
    }
    public int bruteForce(int r, int c, int row, int col){
        if(r == row || c == col) return 0;
        if(r == row-1 && c == col-1) return 1;
        
        int right = bruteForce(r, c+1, row, col);
        int down = bruteForce(r+1, c, row, col);

        return right+down;
    }
}