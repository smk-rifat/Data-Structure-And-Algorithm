package DailyChallenge.DP.LongestCommonSubsequence.Approach_1;
// https://leetcode.com/problems/longest-common-subsequence/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        if (text1.equals(text2)) return text1.length();
        return bruteForce(text1, text2, 0, 0);
    }
    public int bruteForce(String s1, String s2, int i, int j){
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + bruteForce(s1, s2, i+1, j+1);
        else
            return Math.max(bruteForce(s1, s2, i+1, j), bruteForce(s1, s2, i, j+1));
    }
}