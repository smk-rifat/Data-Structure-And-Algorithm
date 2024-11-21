package DailyChallenge.DP.MinimumDifficultyOfAJobSchedule.SpaceOptimization;

import java.util.Arrays;

class Solution {
    public int minDifficulty(int[] job, int d) {
        int n = job.length;
        if (d > n)
            return -1;
        int[] prev = new int[d + 1];
        int[] cur = new int[d + 1];

        for (int i = 0; i < n; i++) {
            prev[i] = getD(job, i);
        }

        for (int days = 2; days <= d; days++) {
             // from day 2 to d
            for (int i = 0; i <= n - days; i++) {
                int maxD = Integer.MIN_VALUE;
                int result = Integer.MAX_VALUE;

                for (int j = i; j <= n - days; j++) {
                    maxD = Math.max(maxD, job[j]);
                    result = Math.min(maxD + prev[j + 1], result);
                }
                cur[i] = result;
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        
        return prev[0];
    }

    public int getD(int[] job, int start) {
        int ans = Integer.MIN_VALUE;
        for (int i = start; i < job.length; i++) {
            ans = Math.max(ans, job[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arm = { { 1, 3 }, { 3, 45, 677 } };
        for (int[] d : arm) {
            System.out.println(Arrays.toString(d));
        }
    }
}
