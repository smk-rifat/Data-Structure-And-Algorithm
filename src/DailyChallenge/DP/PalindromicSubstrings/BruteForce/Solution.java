package DailyChallenge.DP.PalindromicSubstrings.BruteForce;
// https://leetcode.com/problems/palindromic-substrings/

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (s.isEmpty()) return 0;
        if (s.length() < 2) return 1;

        int ans = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n; j++) {
                if (isPalindrome(s, i, j)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int left, int right){
        if (left >= right) return true;
        if (s.charAt(left) == s.charAt(right)) return isPalindrome(s, left+1, right-1);
        return false;
    }
}