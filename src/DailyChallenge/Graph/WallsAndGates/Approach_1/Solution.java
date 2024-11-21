package DailyChallenge.Graph.WallsAndGates.Approach_1;
// https://leetcode.com/problems/walls-and-gates/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols; j++) {
                // Trigger DFS only when the current cell is a Gate
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j,0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int row, int col, int distance) {
        // Corner Cases for DFS.
        // Checks where rows are out of bound, columns are out of bound and if the current cell is a wall.
        // Return from function if any of this is true
        if(row >= rooms.length || row<0 ||
                col >=rooms[0].length || col<0 ||
                rooms[row][col] == -1) {
            return;
        }
        // This is for 2 scenarios
        // 1. If the cell was previously visited and the distance calculated now is more than previous
        // 2. Our Gate cell is called in the same dfs.
        // Return from here for both the cases
        if(rooms[row][col]<=distance && distance !=0) {
            return;
        }
        // Set the cell to closest distance
        rooms[row][col] = distance;
        // Do DFS over all its neighbours
        dfs(rooms, row-1, col, distance+1);
        dfs(rooms, row, col+1, distance+1);
        dfs(rooms, row+1, col, distance+1);
        dfs(rooms, row, col-1, distance+1);
    }
}