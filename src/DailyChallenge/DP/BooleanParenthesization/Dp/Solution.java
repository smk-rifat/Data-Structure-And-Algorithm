package DailyChallenge.DP.BooleanParenthesization.Dp;

class Solution {
    static final int MOD = 1003;

    static int countWays(int n, String s) {
        int[][][] dp = new int[n][n][2]; // DP table to store results

        // Base case: If there's a single character
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = s.charAt(i) == 'T' ? 1 : 0; // True
            dp[i][i][0] = s.charAt(i) == 'F' ? 1 : 0; // False
        }

        // Fill the DP table for all substrings of length 2 and more
        for (int length = 3; length <= n; length += 2) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // End index of the substring

                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    int ways = 0;

                    for (int idx = i + 1; idx <= j - 1; idx += 2) {
                        int lT = dp[i][idx - 1][1];
                        int lF = dp[i][idx - 1][0];

                        int rT = dp[idx + 1][j][1];
                        int rF = dp[idx + 1][j][0];

                        char operator = s.charAt(idx);

                        // Calculate the number of ways based on the operator
                        if (operator == '|') {
                            if (isTrue == 1) {
                                ways = (ways + lT * rT % MOD + lT * rF % MOD + lF * rT % MOD) % MOD;
                            } else {
                                ways = (ways + lF * rF % MOD) % MOD;
                            }
                        } else if (operator == '&') {
                            if (isTrue == 1) {
                                ways = (ways + lT * rT % MOD) % MOD;
                            } else {
                                ways = (ways + lF * rT % MOD + lT * rF % MOD + lF * rF % MOD) % MOD;
                            }
                        } else if (operator == '^') { // XOR operator
                            if (isTrue == 1) {
                                ways = (ways + lT * rF % MOD + lF * rT % MOD) % MOD;
                            } else {
                                ways = (ways + lT * rT % MOD + lF * rF % MOD) % MOD;
                            }
                        }
                    }

                    dp[i][j][isTrue] = ways; // Store the result for this substring and isTrue
                }
            }
        }

        // Return the number of ways to evaluate the entire string to True
        return dp[0][n - 1][1];
    }
}
