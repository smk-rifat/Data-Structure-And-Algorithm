package DailyChallenge.Math_And_BitOperator.FlippingAnImage.Approach_1;
// https://leetcode.com/problems/flipping-an-image/
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            image[i] = reverse(image[i]);
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == 1){
                    image[i][j] = 0;
                } else if (image[i][j] == 0){
                    image[i][j] = 1;
                }
            }
        }
        return image;
    }
    public int[] reverse(int[] rows){
        int i = 0;
        int j = rows.length-1;

        while (i <= j){
            int temp = rows[i];
            rows[i] = rows[j];
            rows[j] = temp;
            i++;
            j--;
        }
        return rows;
    }
}