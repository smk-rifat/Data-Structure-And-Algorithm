package DailyChallenge.DP.LongestPalindromicSubsequence.BruteForce;
// https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = Integer.MIN_VALUE;
        for (int centre = 0; centre <s.length() ; centre++) {
            int len1 = helper(s, centre, centre);
            int len2 = helper(s, centre, centre+1);

            len = Math.max(len, Math.max(len1, len2));
        }
        return len;
    }
    public int helper(String s, int left, int right){
        if (left < 0 || right == s.length()) return 0;

        if (left == right && s.charAt(left) == s.charAt(right)){
            return 1+ helper(s, left -1, right+1);
        }
        else if (s.charAt(left) == s.charAt(right)){
            return 2 + helper(s, left-1, right+1);
        }
        else
            return Math.max(helper(s, left, right+1), helper(s, left-1, right));
    }

}