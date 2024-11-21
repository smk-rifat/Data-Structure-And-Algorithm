package DailyChallenge.RecursionAndBacktracking.Hard.NQueens;
// https://leetcode.com/problems/n-queens/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        System.out.println(ans.toString());
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = ".";
            }
        }
        int row = 0;
        solve(board, row, ans);
        return ans;
    }
    static void solve(String[][] board, int row, List<List<String>> ans){
        if(row == board.length){
            ans.add(list(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = "Q";
                solve(board, row+1, ans);
                board[row][col] = ".";
            }
        }
    }
    static boolean isSafe(String[][] board, int row, int col){
        // for vertical check
        for(int i = 0; i < row ; i++){
            if(board[i][col].equals("Q")){
                return false;
            }
        }
        // for right diagonal
        for(int i = 1; i <= Math.min(row, board.length-1-col); i++){
            if(board[row-i][col+i].equals("Q")){
                return false;
            }
        }
        // for left diagonal

        for(int i = 1; i <= Math.min(row, col); i++){
            if(board[row-i][col-i].equals("Q")){
                return false;
            }
        }
        return true;
    }
    static List<String> list(String[][] board){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++){
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}