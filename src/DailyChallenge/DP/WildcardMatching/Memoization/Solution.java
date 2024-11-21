package DailyChallenge.DP.WildcardMatching.Memoization;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        Boolean[][] dp = new Boolean[n+1][m+1];

        return helper(p, s, n, m, dp);
    }
    public boolean helper(String pattern, String text, int i, int j, Boolean[][] memo){
        if (i == 0 && j == 0) return true;
        if (i == 0 && j > 0) return false;

        if (j == 0 && i > 0){
            for (int k = 1; k <= i ; k++) {
                if (pattern.charAt(k-1) != '*') return false;
            }
            return true;
        }

        if (memo[i][j] != null) return memo[i][j];

        if (pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?')
            memo[i][j] = helper(pattern, text, i-1, j-1, memo);
        else if (pattern.charAt(i-1) == '*')
            memo[i][j] = helper(pattern, text, i-1, j, memo) || helper(pattern, text, i, j-1, memo);
        else
            memo[i][j] = false;
        return memo[i][j];
    }
}

