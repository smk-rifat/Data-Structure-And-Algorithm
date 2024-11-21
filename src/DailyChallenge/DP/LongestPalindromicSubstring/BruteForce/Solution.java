package DailyChallenge.DP.LongestPalindromicSubstring.BruteForce;
// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        String result = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)){
                    String current = s.substring(i, j+1);
                    if (current.length() > result.length()){
                        result = current;
                    }
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s, int i, int j){
        if (i >= j) return true;
        if (s.charAt(i) == s.charAt(j))
            return isPalindrome(s, i+1, j-1);

        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}