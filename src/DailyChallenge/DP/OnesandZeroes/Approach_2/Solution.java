package DailyChallenge.DP.OnesandZeroes.Approach_2;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] store = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            store[i] = getCount(strs[i]);
        }
        Integer[][][] dp = new Integer[store.length][m+1][n+1];
        return memoization(store, m, n, 0, dp);
    }
    public int memoization(int[][] store, int m , int n, int idx, Integer[][][] memo){
        if (idx >= store.length) return 0;
        if(memo[idx][m][n] != null) return memo[idx][m][n];

        int skip = memoization(store, m,n, idx+1, memo);
        int include = 0;

        if (m >= store[idx][0] && n >= store[idx][1]){
            include = 1+memoization(store, m- store[idx][0], n- store[idx][1], idx+1, memo);
        }

        memo[idx][m][n] = Math.max(include, skip);
        return memo[idx][m][n];
    }

    // Helper method to count the number of zeroes and ones in a string
    private int[] getCount(String s) {
        int zeroes = 0;
        int ones = 0;

        // Count zeroes and ones
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroes++;
            } else if (c == '1') {
                ones++;
            }
        }

        return new int[] {zeroes, ones};
    }
}
