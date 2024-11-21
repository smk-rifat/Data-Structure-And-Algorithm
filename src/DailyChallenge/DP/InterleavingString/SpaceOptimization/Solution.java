package DailyChallenge.DP.InterleavingString.SpaceOptimization;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        Boolean[][] memo = new Boolean[m+1][n+1];

        return memoization(s1,s2,s3,0,0,memo);
    }
    public boolean memoization(String s1, String s2, String s3, int i, int j, Boolean[][] memo){
        if (i == s1.length() && j == s2.length() && i+j == s3.length()) return true;
        if (i+j == s3.length()) return false;
        if (memo[i][j] != null) return memo[i][j];

        boolean takeS1 = i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && memoization(s1,s2,s3,i+1, j, memo);
        boolean takeS2 = j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && memoization(s1,s2,s3,i, j+1, memo);

        memo[i][j] = takeS1 || takeS2;
        return memo[i][j];
    }
}