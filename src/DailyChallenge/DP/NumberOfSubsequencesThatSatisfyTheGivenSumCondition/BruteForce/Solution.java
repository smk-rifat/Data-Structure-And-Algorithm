package DailyChallenge.DP.NumberOfSubsequencesThatSatisfyTheGivenSumCondition.BruteForce;
// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

import java.util.Arrays;

class Solution {
    int MOD = 1000000007;
    int n;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        n = nums.length;
        return helper(nums, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, target);
    }

    public int helper(int[] nums, int min, int max, int idx, int target) {
        if (idx == n)
            return (min != Integer.MAX_VALUE && min + max <= target) ? 1 : 0;
        
        int exclude = helper(nums, min, max, idx + 1, target);
        int include = helper(nums, Math.min(min, nums[idx]), 
                            Math.max(max, nums[idx]), idx + 1, target);
        return (exclude + include) % MOD;                   
    }
}
