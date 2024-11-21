package DailyChallenge.DP.PartitionToK_EqualSumSubsets.Backtracking;
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length)
            return false;
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int targetSum = sum / k;
        if (targetSum * k != sum)
            return false;
        boolean[] isTaken = new boolean[nums.length];
        return helper(nums, 0, k,targetSum,0, isTaken);
    }

    public boolean helper(int[] nuts, int count, int k, int targetSum, int curSum, boolean[] isTaken) {
        if (count == k - 1)
            return true;
        if (curSum > targetSum)
            return false;
        if (curSum == targetSum)
            return helper(nuts, count + 1, k, targetSum, 0, isTaken);
        
        for (int index = 0; index < nuts.length; index++) {
            if (!isTaken[index]) {
                isTaken[index] = true;
                if (helper(nuts, count, k, targetSum, curSum + nuts[index], isTaken))
                    return true;
                isTaken[index] = false;
            }
        }
        return false;
    }
}
