package DailyChallenge.DP.LongestPalindromicSubsequence.LCS_Approach.Memoization;

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        int n = s.length();
        Integer[][] memo = new Integer[n+1][n+1];
        return memoization(s, reverse, n, n, memo);
    }
    public int memoization(String a, String b, int m, int n, Integer[][] memo){
        if (m == 0 || n == 0) return 0;
        if (memo[m][n] != null) return memo[m][n];

        if (a.charAt(m-1) == b.charAt(n-1))
            memo[m][n] = 1+memoization(a, b, m-1, n-1, memo);
        else
            memo[m][n] = Math.max(memoization(a, b, m-1, n, memo), memoization(a, b, m, n-1, memo));

        return memo[m][n];
    }
}
