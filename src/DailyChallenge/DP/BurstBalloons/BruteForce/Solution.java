package DailyChallenge.DP.BurstBalloons.BruteForce;
// https://leetcode.com/problems/burst-balloons/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        for (int i = 1; i <= n; i++) {
            balloons [i] = nums[i-1];
        }
        balloons [0] = balloons [n+1] = 1;
        return bruteForce(balloons , 1, n);
    }
    public int bruteForce(int[] nums, int left, int right){
        if (left > right) return 0;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            int cost = (nums[left-1] * nums[i] * nums[right+1]);
            cost += bruteForce(nums, left, i-1);
            cost += bruteForce(nums, i+1, right);
            max = Math.max(max, cost);
        }
       
        return max;
    }
}