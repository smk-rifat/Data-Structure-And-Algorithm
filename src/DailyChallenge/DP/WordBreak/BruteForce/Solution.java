package DailyChallenge.DP.WordBreak.BruteForce;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<String> set;
    int n;
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        n = s.length();
        memo = new Boolean[n + 1];
        for (String str : wordDict) {
            set.add(str);
        }
        return helper(s, 0);
    }

    public boolean helper(String s, int idx) {
        if (idx == n)
            return true;
        if (memo[idx] != null)
            return memo[idx];
        for (int i = idx + 1; i <= n; i++) {
            if (set.contains(s.substring(idx, i)))
                if (helper(s, i)) {
                    memo[idx] = true;
                    return true;
                }            
        }

        memo[idx] = false;
        return memo[idx];
    }
}
