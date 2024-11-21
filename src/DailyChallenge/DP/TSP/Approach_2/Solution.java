package DailyChallenge.DP.TSP.Approach_2;

import java.util.Arrays;

class Solution {
    int[][] cost;
    int n;
    int[][] dp;

    public int total_cost(int[][] cost) {
        this.n = cost.length;
        this.cost = cost;
        dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(1, 0);
    }

    public int helper(int mask, int pos) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int minCost = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newMask = mask | (1 << city);
                int subProblem = cost[pos][city] + helper(newMask, city);
                minCost = Math.min(minCost, subProblem);
            }
        }
        dp[mask][pos] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[][] cost = { { 0, 1000, 5000 }, { 5000, 0, 1000 },
                { 1000, 5000, 0 } };
        Solution obj = new Solution();
        System.out.println(obj.total_cost(cost));
    }
}
