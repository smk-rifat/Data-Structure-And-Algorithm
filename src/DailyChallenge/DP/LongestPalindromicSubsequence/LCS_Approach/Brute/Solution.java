package DailyChallenge.DP.LongestPalindromicSubsequence.LCS_Approach.Brute;

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return helper(s, reverse, 0, 0);
    }
    public int helper(String s1, String s2, int i, int j){
         if (i == s1.length() || j == s2.length()) return 0;
         if (s1.charAt(i) == s2.charAt(j)) return 1+helper(s1,s2,i+1, j+1);
         return Math.max(helper(s1, s2, i+1, j), helper(s1, s2, i, j+1));
    }
}
