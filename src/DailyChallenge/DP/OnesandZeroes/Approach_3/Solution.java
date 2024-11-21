package DailyChallenge.DP.OnesandZeroes.Approach_3;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];

        for (int i = 1; i <= strs.length; i++) {
            int[] count = count(strs[i-1]);
            int zero = count[0];
            int one = count[1];

            for (int j = 0; j <= m ; j++) {
                for (int k = 0; k <= n ; k++) {
                    if (j >= zero && k >= one)
                        dp[i][j][k] = Math.max(dp[i-1][j][k], 1+ dp[i-1][j - zero][k - one]);
                    else
                        dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public int[] count(String s){
        int[] ans = new int[2];
        int zero = 0, one = 0;
        for(char c : s.toCharArray()){
            if (c == '1')
                one ++;
            else
                zero++;
        }
        ans[0] = zero;
        ans[1] = one;
        return ans;
    }
}
