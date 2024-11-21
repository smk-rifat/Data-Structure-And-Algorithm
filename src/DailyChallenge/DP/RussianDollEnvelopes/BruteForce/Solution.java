package DailyChallenge.DP.RussianDollEnvelopes.BruteForce;
// https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0] == b[0]) 
                return b[1] - a[1];
            else 
                return a[0] - b[0];
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);               
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
