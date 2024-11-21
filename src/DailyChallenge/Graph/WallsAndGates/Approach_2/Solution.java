package DailyChallenge.Graph.WallsAndGates.Approach_2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] direction = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
    public void wallsAndGates(int[][] rooms){
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0){
                    queue.add( new int[]{i,j});
                }
            }
        }
        if (queue.isEmpty()) return;
        int level = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int[] dir : direction){
                int x = r + dir[0];
                int y = c + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                queue.add(new int[] {x, y});
                level++;
                rooms[x][y] = level;
            }
        }
    }
}
