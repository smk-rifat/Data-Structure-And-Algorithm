package DailyChallenge.DP.NumberOfSubsequencesThatSatisfyTheGivenSumCondition.Memoization;

class Solution {
    int MOD = 1000000007;
    int n;
    Integer[][][] memo;

    public int numSubseq(int[] nums, int target) {
        //Arrays.sort(nums);
        n = nums.length;
        memo = new Integer[n][n][n];
        return memoization(nums, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, target);
    }

    public int memoization(int[] nums,int idx, int min, int max, int target) {
        if (idx == n)
            return (min != Integer.MAX_VALUE && min + max <= target) ? 1 : 0;
        if (memo[idx][min == Integer.MAX_VALUE ? 0 : min][max == Integer.MIN_VALUE ? 0 : max] != null)
            return memo[idx][min][max];
        
        int exclude = memoization(nums, idx + 1, min, max, target);
        int include = memoization(nums, idx + 1, Math.min(min, nums[idx]), Math.max(max, nums[idx]), target);

        memo[idx][min][max] = (include + exclude) % MOD;

        return memo[idx][min][max];
    }
}
