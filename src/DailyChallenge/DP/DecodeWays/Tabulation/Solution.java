package DailyChallenge.DP.DecodeWays.Tabulation;

import java.util.Set;
import java.util.HashSet;

class Solution {
   
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }
        
        dp[n] = 1;

        for (int idx = n-1; idx >= 0 ; idx--) {
            int ways = 0;
            for (int len = 1; len <= 2; len++) {
                if (idx + len <= n && set.contains(s.substring(idx, idx + len))) {
                    ways += dp[idx + len];
                }
            }
            dp[idx] = ways;
        }
        return dp[0];
    }
}
