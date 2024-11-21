package DailyChallenge.RecursionAndBacktracking.Medium.WordSearch;
// https://leetcode.com/problems/word-search/
class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int wi = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (search(board, word, i, j,m,n,wi)) return true;
                }
            }
        }
        return false;
    }

    static boolean search(char[][] board, String word, int r, int c, int m, int n, int wi) {
        if (r >= m || c >= n || r < 0 || c < 0 || board[r][c] != word.charAt(wi)) return false;
        if (wi == word.length() - 1) return true;

        char ch = board[r][c];
        board[r][c] = '#';
        boolean right = search(board, word, r, c + 1, m, n, wi + 1);
        boolean down = search(board, word, r + 1, c, m, n, wi + 1);
        boolean up = search(board, word, r - 1, c, m, n, wi + 1);
        boolean left = search(board, word, r, c - 1, m, n, wi + 1);
        board[r][c] = ch;
        return right || left || up || down;
    }
}