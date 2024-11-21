package DailyChallenge.Graph.SurroundedRegions.Approach_1;
// https://leetcode.com/problems/surrounded-regions/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void solve(char[][] board) {
        int R = board.length;
        int C = board[0].length;

        // left and right
        for (int r = 0; r < R; r++) {

            // left most column
            if (board[r][0] == 'O'){
                dfs(board, r, 0);
            }

            // right most column
            if (board[r][C-1] == 'O'){
                dfs(board, r, C-1);
            }
        }
        // top and bottom
        for (int c = 0; c < C; c++) {

            // top row
            if (board[0][c] == 'O'){
                dfs(board,0, c);
            }
            // Bottom Row
            if (board[R-1][c] == 'O'){
                dfs(board, R-1, c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }

                if (board[r][c] == '1'){
                    board[r][c] = 'O';
                }
            }
        }

    }
    public void dfs(char[][] board, int r, int c){
        if (r < 0 || c < 0 || r == board.length|| c == board[0].length || board[r][c] != 'O') return;
        board[r][c] = '1';

        dfs(board, r+1,c);
        dfs(board, r-1,c);
        dfs(board, r,c+1);
        dfs(board, r,c-1);
    }
    public void bfs(char[][] board, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        board[r][c] = '1';
        int[][] direction = {{1,0},{-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int[] dir : direction){
                int x = cur[0]+ dir[0];
                int y = cur[1]+ dir[1];

                if (x < 0 || y < 0 || x == board.length || y == board[0].length || board[x][y] != 'O') continue;
                board[x][y] = '1';
                queue.add(new int[]{x, y});
            }
        }
    }

}