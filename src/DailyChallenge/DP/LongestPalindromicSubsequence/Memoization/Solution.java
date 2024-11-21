package DailyChallenge.DP.LongestPalindromicSubsequence.Memoization;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = Integer.MIN_VALUE;
        Integer[][] memo = new Integer[s.length()+1][s.length()+1];
        for (int centre = 0; centre <s.length() ; centre++) {
            int len1 = helper(s, centre, centre, memo);
            int len2 = helper(s, centre, centre+1, memo);
            
            len = Math.max(len, Math.max(len1, len2));
        }
        return len;
    }
    public int helper(String s, int left, int right, Integer[][] memo){
        if (left < 0 || right == s.length()) return 0;
        if (memo[left][right] != null) return memo[left][right];
        if (left == right && s.charAt(left) == s.charAt(right)){
            memo[left][right] = 1+ helper(s, left -1, right+1, memo);
        } 
        else if (s.charAt(left) == s.charAt(right)){
            memo[left][right] = 2 + helper(s, left-1, right+1, memo);
        } 
        else 
            memo[left][right] = Math.max(helper(s, left, right+1, memo), helper(s, left-1, right, memo));
        return memo[left][right];
    }
    
}