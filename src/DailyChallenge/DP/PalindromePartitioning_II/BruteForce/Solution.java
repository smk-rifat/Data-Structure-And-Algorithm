package DailyChallenge.DP.PalindromePartitioning_II.BruteForce;
// https://leetcode.com/problems/palindrome-partitioning-ii/
class Solution {
    public int minCut(String s) {
       int n = s.length();
       return bruteForce(s, 0, n-1);
    }
    public int bruteForce(String s, int start, int end){
        if (start >= end || isPalindrome(s, start, end)) return 0;

        int minCuts = Integer.MAX_VALUE;

        for (int cutsPoint = start; cutsPoint < end; cutsPoint++) {
            if (isPalindrome(s, start, cutsPoint)){
                int cuts = 1 + bruteForce(s, cutsPoint+1, end);
                minCuts = Math.min(cuts, minCuts);
            }
        }
        return minCuts;
    }
    public boolean isPalindrome(String s, int i, int j){
        if (i >= j) return true;
        if (s.charAt(i) == s.charAt(j))
            return isPalindrome(s, i+1, j-1);
        else
            return false;

    }
}
