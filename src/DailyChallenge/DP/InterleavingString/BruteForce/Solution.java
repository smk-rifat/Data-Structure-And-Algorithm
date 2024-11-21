package DailyChallenge.DP.InterleavingString.BruteForce;
// https://leetcode.com/problems/interleaving-string/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) return false;
        return bruteForce(s1,s2,s3,0,0,0);
    }
    public boolean bruteForce(String s1, String s2, String s3, int i, int j, int k){
        if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
        if (k == s3.length()) return false;

        boolean canTakeFromS1 = i < s1.length() && s1.charAt(i) == s3.charAt(k) && bruteForce(s1,s2,s3, i+1, j, k+1);
        boolean canTakeFromS2 = j < s2.length() && s2.charAt(j) == s3.charAt(k) && bruteForce(s1, s2,s3,i, j+1, k+1);

        return canTakeFromS1 || canTakeFromS2;
    }
}