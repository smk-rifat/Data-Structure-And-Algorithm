package DailyChallenge.DP.BurstBalloons.Memoization;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = balloons[n+1] = 1;
        System.arraycopy(nums, 0, balloons, 1, n);
        Integer[][] memo = new Integer[balloons.length+1][balloons.length+1];
        return memoization(balloons, 1, n, memo);
    }
    public int memoization(int[] balloons, int left, int right, Integer[][] memo){
        if (memo[left][right] != null) return memo[left][right];
        if (left > right) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            int cost = balloons[left-1] * balloons[i] * balloons[right+1];
            cost += memoization(balloons,left, i-1,memo);
            cost += memoization(balloons, i+1, right,memo);
            max = Math.max(max, cost);
        }
        memo[left][right] = max;
        return memo[left][right];
    }
}