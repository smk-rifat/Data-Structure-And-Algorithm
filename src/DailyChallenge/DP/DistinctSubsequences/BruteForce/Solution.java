package DailyChallenge.DP.DistinctSubsequences.BruteForce;
// https://leetcode.com/problems/distinct-subsequences/
class Solution {
    public int numDistinct(String s, String t) {
        return bruteForce(s, t, 0, 0);
    }
    public int bruteForce(String s, String t, int i, int j){
        if (j >= t.length()) return 1;
        if (i >= s.length() ) return 0;

        if (s.charAt(i) == t.charAt(j)){
            return bruteForce(s, t, i+1, j+1) + bruteForce(s, t, i+1, j);
        } else
            return bruteForce(s, t, i+1, j);
    }
}
