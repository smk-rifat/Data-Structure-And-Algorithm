package DailyChallenge.DP.DecodeWays.BruteForce;
// https://leetcode.com/problems/decode-ways/description/

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> set;
    int n;
    Integer[] memo;

    public int numDecodings(String s) {
        n = s.length();
        memo = new Integer[n + 1];
        set = new HashSet<>();

        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }

        return memoization(s, 0);
    }

    public int memoization(String s, int idx) {
        if (idx == n)
            return 1;

        if (memo[idx] != null)
            return memo[idx];
        int ways = 0;
        for (int i = idx + 1; i <= n; i++) {
            if (set.contains(s.substring(idx, i))) {
                ways += memoization(s, i);
            }
        }

        memo[idx] = ways;
        return memo[idx];
    }
}
