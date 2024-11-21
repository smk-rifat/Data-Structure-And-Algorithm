package DailyChallenge.Graph.NumberOfIslands.Approach_2;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int numOfIslands = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1'){
                    numOfIslands++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()){
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        int[][] neighbours = {{r+1, c},{r-1,c },{r, c+1},{r, c-1}};

                        for (int[] n : neighbours) {
                            int newR = n[0];
                            int newC = n[1];

                            if (newR >= 0 && newC >= 0 && newR < R && newC < C && grid[newR][newC] == '1'){
                                queue.add(new int[]{newR, newC});
                                grid[newR][newC] = '0';
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}