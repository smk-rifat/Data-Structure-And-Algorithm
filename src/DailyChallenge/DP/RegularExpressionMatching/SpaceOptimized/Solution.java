package DailyChallenge.DP.RegularExpressionMatching.SpaceOptimized;


class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        boolean [] cur = new boolean[m+1];
        boolean [] minus1 = new boolean[m+1];
        boolean [] minus2 = new boolean[m+1];
        minus1[0] = true;

        for(int j = 1; j <= m; j++){
            minus1[j] = false;
        }

        

        for(int i = 1; i <= n; i++){
            int flag = i;
            while(flag>= 1 && p.charAt(flag-1) == '*'){
                flag = flag-2;
            }
            cur[0] = (flag == 0);

            for(int j = 1; j <= m;  j++){
                boolean match = false;
                if(p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1)){
                    match = minus1[j-1];
                } else if(p.charAt(i-1) == '*'){
                    boolean zero = minus2[j];
                    boolean action = (p.charAt(i-2) == '.' || p.charAt(i-2) == s.charAt(j-1)) && cur[j-1];
                    match = zero || action;
                }
                cur[j] = match;
            }
            boolean[] temp = minus2;
            minus2 = minus1;
            minus1 = cur;
            cur = temp;
        }
        return minus1[m];
    }
}
