package DailyChallenge.Math_And_BitOperator.FlippingAnImage.Approach_2;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            int left = 0;
            int right = image[i].length-1;
            while (left <= right){
                if (image[i][left] == image[i][right]){
                    if(image[i][left] == 1){
                        image[i][left] = 0;
                        image[i][right] = 0;
                    } else if (image[i][left] == 0){
                        image[i][left] = 1;
                        image[i][right] = 1;
                    }
                }
                left++;
                right--;
            }
        }
        return image;
    }
}