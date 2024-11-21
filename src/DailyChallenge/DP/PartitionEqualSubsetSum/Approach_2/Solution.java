package DailyChallenge.DP.PartitionEqualSubsetSum.Approach_2;

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length][targetSum + 1];
        
        return canPartitionHelper(nums, targetSum, 0, memo);
    }

    private boolean canPartitionHelper(int[] nums, int targetSum, int idx, Boolean[][] memo) {
        // Base cases
        if (targetSum == 0) return true;
        if (idx >= nums.length || targetSum < 0) return false;

        // Check memo table
        if (memo[idx][targetSum] != null) return memo[idx][targetSum];

        // Recursive calls
        boolean skip = canPartitionHelper(nums, targetSum, idx + 1, memo);
        boolean include = canPartitionHelper(nums, targetSum - nums[idx], idx + 1, memo);

        // Store result in memo table
        memo[idx][targetSum] = skip || include;
        return memo[idx][targetSum];
    }
}

