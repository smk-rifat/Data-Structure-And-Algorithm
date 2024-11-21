package DailyChallenge.DP.WordBreak.Tabulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (String str : wordDict) {
            set.add(str);
        }
        boolean[] dp = new boolean[n + 2];
        dp[n] = true;
        
        for (int idx = n - 1; idx >= 0; idx--) {
            
            for (int i = idx + 1; i <= n; i++) {
                if (set.contains(s.substring(idx, i)) && dp[i]) {
                    dp[idx] = true;
                    break;
                }
            }
        }
        return dp[0];
    }   
}
