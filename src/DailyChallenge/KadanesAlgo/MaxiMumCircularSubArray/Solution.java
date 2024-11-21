package DailyChallenge.KadanesAlgo.MaxiMumCircularSubArray;
// https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
    public static void main(String[] args){
        int[] nums = {5,-3,5};
        int ans = maxSubarraySumCircular(nums);
        System.out.println(ans);

    }
    public static int maxSubarraySumCircular(int[] nums) {
        int gMax = nums[0];
        int cMax = 0;
        int total = 0;
        int cMin = 0;
        int gMin = nums[0];

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            cMax += nums[i];
            gMax = Math.max(gMax, cMax);

            if(cMax < 0){
                cMax = 0;
            }

            cMin += nums[i];
            gMin = Math.min(gMin, cMin);

            if(cMin > 0){
                cMin = 0;
            }
        }
        return gMax > 0 ? Math.max(gMax, total- gMin) : gMax;
        // here time Complexity is O(n)
        // using traditional kadanes algorithm.
    }
}