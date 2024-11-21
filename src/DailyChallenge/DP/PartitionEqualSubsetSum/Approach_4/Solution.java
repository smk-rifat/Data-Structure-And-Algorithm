package DailyChallenge.DP.PartitionEqualSubsetSum.Approach_4;

class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for(int num: nums){
            targetSum += num;
        }
        if (targetSum % 2 != 0) return false;
        targetSum /= 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums){
            for (int i = targetSum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[targetSum];
    }
}