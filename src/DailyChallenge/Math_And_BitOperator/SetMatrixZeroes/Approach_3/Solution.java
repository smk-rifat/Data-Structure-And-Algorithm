package DailyChallenge.Math_And_BitOperator.SetMatrixZeroes.Approach_3;

class Solution {
    public void setZeroes(int[][] matrix) {
        int col = 1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0){
                    // marked row
                    matrix[r][0] = 0;

                    //marked column
                    if (c != 0){
                        matrix[0][c] = 0;
                    } else {
                        col = 0;
                    }
                }
            }
        }
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) matrix[r][c] = 0;
            }
        }
        if (matrix[0][0] == 0){
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
        if (col == 0){
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}