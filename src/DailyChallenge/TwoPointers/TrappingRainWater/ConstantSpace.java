package DailyChallenge.TwoPointers.TrappingRainWater;

public class ConstantSpace {
    public static void main(String[] args){

    }
    public static int trap(int[] height){
        int n = height.length;
        int left = 1;
        int right = n-2;
        int maxL = height[0];
        int maxR = height[n-1];
        int water = 0;
        while (left<right) {
            if (maxL<maxR) {
                left++;
                maxL = Math.max(maxL, height[left]);
                water += maxL- height[left];
            }
            else {
                right--;
                maxR = Math.max(maxR, height[right]);
                water += maxR - height[right];
            }

        }
    return water;
    }
}
