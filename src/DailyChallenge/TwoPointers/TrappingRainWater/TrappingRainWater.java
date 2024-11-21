package DailyChallenge.TwoPointers.TrappingRainWater;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater
{
    public static void main(String[] args) {
       int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        int[] left = left(height);
        int[] right = right(height);
        int containedWater = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            int water = min-height[i];
            if (water>0){
                containedWater += water;
            }
        }
        return containedWater;
    }
    public static int[] left(int[] height){
        int[] ans = new int[height.length];
        int left = Integer.MIN_VALUE;

        for (int i = 1; i < height.length; i++) {
            if (height[i-1]>left)
            {
                ans[i] = height[i-1];
                left = height[i-1];
            }
            else
                ans[i] = left;
        }
        return ans;
    }
    public static int[] right(int[] height){
        int n = height.length;
        int[] ans = new int[n];
        int right = Integer.MIN_VALUE;

        for (int i = n-2; i >=0 ; i--) {
            if (height[i+1]> right){
                ans[i] = height[i+1];
                right = height[i+1];
            }
            else
                ans[i] = right;
        }
        return ans;
    }
}
