package DailyChallenge.DP.BooleanParenthesization.Memoization;

class Solution{
    static int MOD = 1003;
    static int countWays(int n, String s){
        Integer[][][] memo = new Integer[n+1][n+1][2];
        return bruteForce(s, 0, n-1, 1, memo);
    }
    public static int bruteForce(String s, int i, int j, int isTrue, Integer[][][] memo){
        if (i > j) return 0;
        if (memo[i][j][isTrue] != null) return memo[i][j][isTrue];
        if (i == j){
            if (isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        int ways = 0;

        for (int idx = i+1; idx <= j-1; idx++) {
            int lT = bruteForce(s,i, idx-1, 1, memo);
            int lF = bruteForce(s,i, idx-1, 0, memo);

            int rT = bruteForce(s, idx+1, j, 1, memo);
            int rF = bruteForce(s, idx+1, j, 0, memo);

            char operator = s.charAt(idx);

            if (operator == '|'){
                if (isTrue == 1){
                    ways = (ways + (lT * rT) % MOD + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                } else
                    ways = (ways + (lF * rF) % MOD) % MOD;
            } else if (operator == '&'){
                if (isTrue == 1){
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
            } else {
                if (isTrue == 1){
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                } else
                    ways = (ways + (lT * rT) % MOD + (lF * rF) % MOD) % MOD;
            }
        }
        memo[i][j][isTrue] = ways;
        return memo[i][j][isTrue];
    }
    public static void main(String[] args) {

    }
}