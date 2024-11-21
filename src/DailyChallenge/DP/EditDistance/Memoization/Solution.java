package DailyChallenge.DP.EditDistance.Memoization;

class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return memoization(word1, word2, 0, 0, memo);
    }
    public int memoization(String s1, String s2, int i, int j, Integer[][] memo){
        if (i >= s1.length() || s1.isEmpty()) return s2.length() - j;
        if (j >= s2.length() || s2.isEmpty()) return s1.length() - i;
        if (memo[i][j] != null) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)){
            memo[i][j]= memoization(s1, s2, i+1, j+1, memo);
        } else{
            int insert = 1 + memoization(s1, s2, i, j+1, memo);
            int replace = 1+ memoization(s1,s2,i+1, j+1, memo);
            int remove = 1+ memoization(s1, s2, i+1, j, memo);
            memo[i][j] = Math.min(insert, Math.min(replace, remove));
        }
        return memo[i][j];
    }
}