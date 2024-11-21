package DailyChallenge.Math_And_BitOperator.SpiralMatrix.Approach_1;
// https://leetcode.com/problems/spiral-matrix/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int topRow = 0;
        int bottomRow = matrix.length-1;
        int leftCol = 0;
        int rightCol = matrix[0].length-1;

        while (topRow <= bottomRow && leftCol <= rightCol){
            // left to right column traverse
            for (int col = leftCol; col <= rightCol ; col++) {
                result.add(matrix[topRow][col]);
            }
            topRow++;

            // from rightMost top to bottom
            for (int row = topRow; row <= bottomRow; row++) {
                result.add(matrix[row][rightCol]);
            }
            rightCol--;

            // from right to left
            if (topRow <= bottomRow){
                for (int col = rightCol; col >= leftCol; col--) {
                    result.add(matrix[bottomRow][col]);
                }
                bottomRow--;
            }

            // leftMost col bottom to top
            if (leftCol <= rightCol){
                for (int row = bottomRow; row >= topRow ; row--) {
                    result.add(matrix[row][leftCol]);
                }
                leftCol++;
            }
        }

        return result;
    }
}