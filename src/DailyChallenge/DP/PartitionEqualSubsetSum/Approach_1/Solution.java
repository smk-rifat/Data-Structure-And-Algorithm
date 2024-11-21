package DailyChallenge.DP.PartitionEqualSubsetSum.Approach_1;
// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        int n = 0;
        for(int i : nums){
            n += i;
        }
        if (n % 2 != 0) {
            return false;
        }
        n /= 2;
        return bruteForce(nums, n, 0);
    }
    public boolean bruteForce(int[] nums, int n, int i){
        if(i >= nums.length || n < 0) return false;
        if (n == 0) return true;
        return bruteForce(nums, n, i+1) || bruteForce(nums, n - nums[i], i+1);
    }
}
