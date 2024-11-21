package DailyChallenge.DP.WildcardMatching.BruteForce;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        return helper(p, s, n-1, m-1);
    }
    public boolean helper(String pattern, String text, int i, int j){
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;

        if (j < 0 && i >= 0){
            for (int k = 0; k <= i ; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?'){
            return helper(pattern, text, i-1, j-1);
        }
        if (pattern.charAt(i) == '*'){
            return helper(pattern, text, i-1, j) || helper(pattern, text, i, j-1);
        }

        return false;
    }
}