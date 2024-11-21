package DailyChallenge.DP.WordBreak.Tabulation_2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            minLen = Math.min(word.length(), minLen);
            maxLen = Math.max(maxLen, word.length());
            set.add(word);
        }
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int len = minLen; len <= maxLen; len++) {
                int end = idx + len;
                if (end <= n && set.contains(s.substring(idx, end)) && dp[end]) {
                    dp[idx] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}