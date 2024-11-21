package DailyChallenge.DP.RussianDollEnvelopes.Better;

import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n <= 1) return 1;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });

        int[] dp = new int[n];
        int len = 0;

        for (int[] envelope : envelopes) {
            int currentHeight = envelope[1];

            int left = 0, right = len;

            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] > currentHeight) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == len) {
                dp[len] = currentHeight;
                len++;
            } else {
                dp[left] = currentHeight;
            }
        }

        return len;
    }
}
