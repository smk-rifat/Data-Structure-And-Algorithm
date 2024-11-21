package DailyChallenge.DP.LongestPalindromicSubstring.Memoization;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        String result = "";
        Boolean[][] memo = new Boolean[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, memo)){
                    memo[i][j] = true;
                    String current = s.substring(i, j+1);
                    if (current.length() > result.length()){
                        result = current;
                    }
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s, int i, int j, Boolean[][] memo){
        if (memo[i][j] != null) return memo[i][j];
        if (i >= j){
            memo[i][j] = true;
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j))
            memo[i][j] = isPalindrome(s, i+1, j-1, memo);
        else
            memo[i][j] = false;

        return memo[i][j];
    }
}