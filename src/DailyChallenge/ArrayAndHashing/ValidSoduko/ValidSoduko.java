package DailyChallenge.ArrayAndHashing.ValidSoduko;

import java.util.HashMap;

public class ValidSoduko {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i<9; i++){
            HashMap<Character, Integer> row = new HashMap<>();
            HashMap<Character, Integer> column = new HashMap<>();
            for (int j = 0; j <9; j++) {
                if (board[i][j] != '.' && row.containsKey(board[i][j])) {
                    return false;
                }
                else
                row.put(board[i][j], 1);
                if (board[j][i] != '.' && column.containsKey(board[j][i])) {
                    return false;
                }
                else
                column.put(board[j][i], 1);
                
            }
        }
        return true;
    }
    
}
