package DailyChallenge.DP.PalindromicSubstrings.DynamicProgramming;

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(s.isEmpty()) return 0;
        if(n < 2) return 1;
        boolean[][] dp = new boolean[n+1][n+1];
        int count = 0;

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n -l ; i++) {
                int j = i+l-1;

                if (l == 1){
                    dp[i][j] = true;
                } else if(l == 2){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);
                }

                if (dp[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
}