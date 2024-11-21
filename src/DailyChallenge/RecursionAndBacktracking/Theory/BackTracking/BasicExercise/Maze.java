package DailyChallenge.RecursionAndBacktracking.Theory.BackTracking.BasicExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int step = 1;
        int r = 0;
        int c = 0;
        boolean[][] board =
                {{true, true, true},
                {true, true, true},
                {true, true, true}};
        int[][] path = new int[board.length][board[0].length];
        allPathPrint(sb, board,r,c,path,step);
    }
    static int count(int r, int c){
        if (r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left+right;
    }
    static List<String> path(StringBuilder p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p.toString());
            return list;
        }
        List<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(path(new StringBuilder(p).append('D'), r - 1, c));
        }
        if (c > 1) {
            ans.addAll(path(new StringBuilder(p).append('R'), r, c - 1));
        }
        return ans;
    }
    static List<String> pathRestricted(StringBuilder sb, boolean[][] maze, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            List<String> list = new ArrayList<>();
            list.add(sb.toString());
            return list;
        }
        if (!maze[r][c]){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        if (r < maze.length-1){
            ans.addAll(pathRestricted(new StringBuilder(sb).append('D'), maze, r+1, c));
        }
        if (c < maze[0].length-1){
            ans.addAll(pathRestricted(new StringBuilder(sb).append('R'), maze, r, c+1));
        }
        return ans;
    }
    static List<String> allPath(StringBuilder sb , boolean[][] maze, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            List<String> list = new ArrayList<>();
            list.add(sb.toString());
            return list;
        }
        if (!maze[r][c]){
            return new ArrayList<>(); // that's mean this cell is already visited
        }
        maze[r][c] = false;
        List<String> ans = new ArrayList<>();
        if (r < maze.length-1){
            ans.addAll(allPath(new StringBuilder(sb).append('D'), maze, r+1, c));
        }
        if (c < maze[0].length-1){
            ans.addAll(allPath(new StringBuilder(sb).append('R'), maze, r, c+1));
        }
        if (r > 0){
            ans.addAll(allPath(new StringBuilder(sb).append('U'), maze, r-1, c));
        }
        if (c > 0){
            ans.addAll(allPath(new StringBuilder(sb).append('L'), maze, r, c-1));
        }
        maze[r][c] = true;
        return ans;

    }
    static void allPathPrint(StringBuilder sb , boolean[][] maze, int r, int c, int[][] path, int  step){
        if (r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for (int[] p : path){
                System.out.println(Arrays.toString(p));
            }
            System.out.println(sb.toString());
            System.out.println();
            return;
        }
        if (!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length-1){
            allPathPrint(new StringBuilder(sb).append('D'), maze, r+1, c, path, step+1);
        }
        if (c < maze[0].length-1){
            allPathPrint(new StringBuilder(sb).append('R'), maze, r, c+1, path, step+1);
        }
        if (r>0){
            allPathPrint(new StringBuilder(sb).append('U'), maze, r-1, c, path, step+1);
        }
        if (c > 0){
            allPathPrint(new StringBuilder(sb).append('L'), maze, r, c-1, path, step+1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
