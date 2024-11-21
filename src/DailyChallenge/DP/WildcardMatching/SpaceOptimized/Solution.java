package DailyChallenge.DP.WildcardMatching.SpaceOptimized;

class Solution {
    public boolean isMatch(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();

        boolean[] prev = new boolean[m+1];
        boolean[] cur = new boolean[m+1];

        prev[0] = true;

        for (int j = 1; j <=m ; j++) {
            prev[j] = false;
        }


        for (int i = 1; i <= n; i++) {
            //---------------------------------
            boolean flag = true;
            for (int k = 1; k <= i ; k++) {
                if (pattern.charAt(k-1) != '*') {
                    flag = false;                       // this portion is for base case
                    break;
                }
            }
            cur[0] = flag;
            //------------------------------------
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?')
                    cur[j] = prev[j-1];
                else if (pattern.charAt(i-1) == '*')
                    cur[j] = prev[j] || cur[j-1];
                else
                    cur[j] = false;
            }
            boolean[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[m];
    }
}