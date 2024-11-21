package DailyChallenge.DP.PartitionEqualSubsetSum.Approach_3;

class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        int n = nums.length;
        for(int num : nums){targetSum += num;}
        if (targetSum % 2 != 0) return false;
        targetSum /= 2;
        boolean[][] dp = new boolean[n+1][targetSum+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {

    }
}