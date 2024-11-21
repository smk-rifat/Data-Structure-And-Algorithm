package DailyChallenge.Math_And_BitOperator.SetMatrixZeroes.Approach_1;
// https://leetcode.com/problems/set-matrix-zeroes/
import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isMarked = new boolean[row][col];

        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (matrix[r][c] == 0){
                    marked(matrix,r,c, isMarked);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (isMarked[r][c]){
                    matrix[r][c] = 0;
                }
            }
        }

    }
    public void marked(int[][] matrix, int row, int col, boolean[][] isMarked){
        // to left side
        isMarked[row][col] = true;
        for (int c = col-1; c >= 0 ; c--) {
            if (matrix[row][c] != 0){
                isMarked[row][c] = true;
            }
        }
        // right side
        for (int c = col+1; c < matrix[0].length ; c++) {
            if (matrix[row][c] != 0){
                isMarked[row][c] = true;
            }
        }
        // to upwards
        for (int r = row-1; r >= 0 ; r--) {
            if (matrix[r][col] != 0){
                isMarked[r][col] = true;
            }
        }
        // to downwards
        for (int r = row+1; r < matrix.length; r++) {
            if (matrix[r][col] != 0){
                isMarked[r][col] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution obj = new Solution();
        obj.setZeroes(matrix);
        for(int[] m: matrix){
            System.out.println(Arrays.toString(m));
        }
    }
}