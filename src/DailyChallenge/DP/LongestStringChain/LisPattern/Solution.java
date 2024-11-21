package DailyChallenge.DP.LongestStringChain.LisPattern;

import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Comparator<String> comp = new Comparator<>(){
            public int compare(String x, String y){
                return Integer.compare(x.length(), y.length());
            }
        };
        Arrays.sort(words, comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (isPredecessor(words[j], words[i])) 
                    if (dp[j] + 1 > dp[i]) 
                        dp[i] = dp[j] + 1;         
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public boolean isPredecessor(String x, String y) {
        int m = x.length();
        int n = y.length();

        if (m > n || m + 1 != n)
            return false;
        
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j))
                i++;
            j++;
        }

        return i == m;
    }
}
