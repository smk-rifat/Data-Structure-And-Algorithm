package DailyChallenge.TwoPointers.ContainerWithMostWater;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater
{
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(optimalWay(height));
    }
    public static int bruteForce(int[] height) {
        int n = height.length;
    int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int curWater = (j-i)*Math.min(height[i], height[j]);
                if (curWater>maxWater)
                {
                    maxWater = curWater;
                }
            }
        }
        return maxWater;
    }
    public static int optimalWay(int[] height){
        int n = height.length;
        int start = 0;
        int end = n-1;
        int area = Integer.MIN_VALUE;
        while (start<end)
        {
            int length = end-start;
            int minHeight = Math.min(height[start],height[end]);
            int curArea = length*minHeight;
            area = Math.max(curArea, area);
            if (height[start]>height[end]){
                end--;
            } else {
                start++;
            }
        }
        return area;
    }

}
// both solution I have solved by myself :)
