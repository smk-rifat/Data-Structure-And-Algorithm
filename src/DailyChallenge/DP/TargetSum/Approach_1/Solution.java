package DailyChallenge.DP.TargetSum.Approach_1;
// https://leetcode.com/problems/target-sum/
class Solution {
    public int findTargetSumWays(int[] nums, int target){
        return bruteForce(nums, target, 0);
    }
    public int bruteForce(int[] nums, int target, int idx){
        if(idx == nums.length) return target == 0 ? 1 : 0;
        int add = bruteForce(nums, target+nums[idx], idx+1);
        int subtract = bruteForce(nums, target - nums[idx], idx+1);
        return add+subtract;
    }
}