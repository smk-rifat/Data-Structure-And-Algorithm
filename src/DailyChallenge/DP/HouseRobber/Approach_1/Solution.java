package DailyChallenge.DP.HouseRobber.Approach_1;
// https://leetcode.com/problems/house-robber/
class Solution {
    int maxRob = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        helper(nums, 0, 0);
        return maxRob;
    }
    public void helper(int[] nums, int count, int index){
        if (index >= nums.length){
            maxRob = Math.max(count, maxRob);
            return;
        }
        helper(nums, count, index+1);
        helper(nums, count+nums[index], index+2);
    }
}
// not optimized one, its classic recursive approach
