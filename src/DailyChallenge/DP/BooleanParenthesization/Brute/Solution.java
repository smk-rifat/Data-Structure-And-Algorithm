package DailyChallenge.DP.BooleanParenthesization.Brute;
// https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
class Solution{
    static int MOD = 1003;
    static int countWays(int n, String s){
        return bruteForce(s, 0, n-1, 1);
    }
    public static int bruteForce(String s, int i, int j, int isTrue){
        if (i > j) return 0;

        if (i == j){
            if (isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        int ways = 0;

        for (int idx = i+1; idx <= j-1; idx++) {
            int lT = bruteForce(s,i, idx-1, 1);
            int lF = bruteForce(s,i, idx-1, 0);

            int rT = bruteForce(s, idx+1, j, 1);
            int rF = bruteForce(s, idx+1, j, 0);

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

        return ways;
    }
}