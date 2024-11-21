package DailyChallenge.Graph.ShortestPathInBinaryMatrix.Approach_1;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       return shortPath(grid);
    }
    static int shortPath(int[][] grid){
        int R = grid.length;
        int C = grid[0].length;
        int shortPath = Integer.MIN_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[R][C];
        visit[0][0] = true;
        queue.add(new int[]{0,0,0});

        while (!queue.isEmpty()){
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                int path = cell[2];
                shortPath = Math.max(shortPath, path);

                int[][] neighbours = {{r+1, c},{r-1, c}, {r, c+1}, {r, c-1}, {r+1, c+1}, {r+1, c-1}, {r-1, c-1}, {r-1, c+1}};

                for (int[] neighbour : neighbours){
                    int newR = neighbour[0];
                    int newC = neighbour[1];
                    if (newR >= 0 && newC >= 0 && newR < R && newC < C && grid[newR][newC] == 1 && !visit[newR][newC]){
                        queue.add(new int[]{newR, newC, path+1});
                        visit[newR][newC] = true;
                    }
                }
            }
        }
        return shortPath;
    }
}