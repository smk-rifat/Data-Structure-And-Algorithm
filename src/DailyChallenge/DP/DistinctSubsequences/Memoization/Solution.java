package DailyChallenge.DP.DistinctSubsequences.Memoization;

class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] memo = new Integer[s.length()][t.length()];
        return memoization(s, t, 0, 0, memo);
    }
    public int memoization(String s, String t, int i, int j, Integer[][] memo){
        if (j >= t.length()) return 1;
        if (i >= s.length()) return 0;

        if (memo[i][j] != null) return memo[i][j];

        if (s.charAt(i) == t.charAt(j)){
            memo[i][j] = memoization(s, t, i+1, j+1, memo) + memoization(s, t, i+1, j, memo);
            return memo[i][j];
        } else {
            memo[i][j] = memoization(s, t, i+1, j, memo);
            return memo[i][j];
        }

    }
}