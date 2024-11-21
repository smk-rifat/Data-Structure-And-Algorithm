package DailyChallenge.DP.TargetSum.Approach_2;

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){sum += num;}
        if(Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

        int n = nums.length;
        int subSum = (target+sum)/2;

        int[][] memo = new int[n+1][subSum+1];
        for(int[] m : memo){Arrays.fill(m , -1);}

        return memoization(nums, subSum, memo, 0);
    }
    public int memoization(int[] nums, int target, int[][] memo, int idx){
        if (idx == nums.length) return target == 0 ? 1 : 0;
        if (memo[idx][target] != -1) return memo[idx][target];

        int include = 0;
        if (target >= nums[idx]) { // Only include if it does not lead to negative target
            include = memoization(nums, target - nums[idx], memo, idx + 1);
        }
        int skip = memoization(nums, target, memo, idx+1);

        memo[idx][target] = skip+include;

        return memo[idx][target];
    }
}