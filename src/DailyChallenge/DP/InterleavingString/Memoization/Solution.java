package DailyChallenge.DP.InterleavingString.Memoization;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        Boolean[][][] memo = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return memoization(s1,s2,s3,0,0,0,memo);
    }

    private boolean memoization(String s1, String s2, String s3, int i, int j, int k, Boolean[][][] memo) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
        if (k >= s3.length()) return false;
        if (memo[i][j][k] != null) return memo[i][j][k];
        
        boolean canTakeFromS1 = i < s1.length() && s1.charAt(i) == s3.charAt(k) && memoization(s1,s2,s3,i+1, j, k+1, memo);
        boolean canTakeFromS2 = j < s2.length() && s2.charAt(j) == s3.charAt(k) && memoization(s1,s2,s3,i,j+1, k+1, memo);
        
        memo[i][j][k] = canTakeFromS1 || canTakeFromS2;
        
        return memo[i][j][k];
    }
}