package DailyChallenge.DP.RegularExpressionMatching.Memoization;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] memo = new Boolean[n + 1][m + 1];
        return helper(p, s, n - 1, m - 1, memo);
    }
    public boolean helper(String p, String s, int i, int j, Boolean[][] memo) {
        if (i < 0 && j < 0) return true;
        if (i < 0) return false;
        if (j < 0) {
            while (i >= 0 && p.charAt(i) == '*') {
                i -= 2;
            }
            return i < 0;
        }
        if (memo[i][j] != null) return memo[i][j];

        boolean match;
        if (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
            match = helper(p, s, i - 1, j - 1, memo);
        } else if (p.charAt(i) == '*') {
            match = helper(p, s, i - 2, j, memo) || (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j)) && helper(p, s, i, j - 1, memo);
        } else {
            match = false;
        }

        memo[i][j] = match;
        return match;
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        Solution obj = new Solution();
        System.out.println(obj.isMatch(s, p)); // Should print true
    }
}