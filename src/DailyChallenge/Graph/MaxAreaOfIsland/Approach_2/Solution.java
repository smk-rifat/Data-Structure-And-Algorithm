package DailyChallenge.Graph.MaxAreaOfIsland.Approach_2;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int maxAreaOfIsland(int[][] grid){
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cArea = 0;

                if (grid[i][j] == 1){
                    queue.add(new int[] {i,j});

                    while (!queue.isEmpty()){
                        int[] cell = queue.poll();
                        cArea ++;
                        int r = cell[0];
                        int c = cell[1];
                        grid[r][c] = 0;
                        int[][] neighbours = {{r+1, c},{r-1, c},{r, c+1},{r, c-1}};
                        for (int[] neighbour : neighbours){
                            int newR = neighbour[0];
                            int newC = neighbour[1];

                            if (newR >= 0 && newC >= 0 && newR < R && newC < C && grid[newR][newC] == 1){
                                queue.add(new int[]{newR, newC});
                                grid[newR][newC] = 0;
                            }
                        }
                    }
                }
                maxArea = Math.max(maxArea, cArea);
            }
        }
        return maxArea;
    }
}
