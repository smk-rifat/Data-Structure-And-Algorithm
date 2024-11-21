package DailyChallenge.DP.RegularExpressionMatching.Dp;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
        }

        for(int i = 1; i <= n; i++){
            int flag = i;
            while(flag>= 1 && p.charAt(flag-1) == '*'){
                flag = flag-2;
            }
            dp[i][0] = (flag == 0);
        }

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=m;  j++){
                boolean match = false;
                if(p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1)){
                    match = dp[i-1][j-1];
                } else if(p.charAt(i-1) == '*'){
                    boolean zero = dp[i-2][j];
                    boolean action = (p.charAt(i-2) == '.' || p.charAt(i-2) == s.charAt(j-1)) && dp[i][j-1];
                    match = zero || action;
                }
                dp[i][j] = match;
            }
        }
        return dp[n][m];
    }
}
