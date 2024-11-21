package DailyChallenge.DP.HouseRobber.Approach_2;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }
    public int helper(int[] nums, int idx, int[] memo){
        if (idx >= nums.length) return 0;
        if (memo[idx] != -1) return memo[idx];

        int rob = nums[idx] + helper(nums, idx+2, memo);
        int skip = helper(nums, idx+1, memo);

        memo[idx] = Math.max(rob, skip);
        return memo[idx];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Solution obj = new Solution();
        System.out.println(obj.rob(nums));
    }
}