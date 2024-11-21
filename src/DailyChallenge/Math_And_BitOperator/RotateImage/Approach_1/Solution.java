package DailyChallenge.Math_And_BitOperator.RotateImage.Approach_1;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
class Solution {
    public void rotate(int[][] matrix) {
        // reverse rows
        int left = 0;
        int right = matrix.length-1;
        while (left <= right){
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        obj.rotate(matrix);
        for (int[] mat : matrix){
            System.out.println(Arrays.toString(mat));
        }
    }
}