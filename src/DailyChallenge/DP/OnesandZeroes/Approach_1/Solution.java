package DailyChallenge.DP.OnesandZeroes.Approach_1;
// https://leetcode.com/problems/ones-and-zeroes/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] store = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            store[i] = count(strs[i]);
        }
        return bruteForce(store, m, n, 0);
    }
    public int bruteForce(int[][] store, int m , int n, int idx){
        if (idx >= store.length) return 0;
        int zero = store[idx][0];
        int one = store[idx][1];

        int skip = bruteForce(store, m, n, idx+1);
        int include = 0;

        if (m >= zero && n >= one)
            include = 1 + bruteForce(store, m - zero, n - one, idx+1);
        return Math.max(skip, include);
    }
    public int[] count(String str){
        int[] ans = new int[2];
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1')
                one++;
            else
                zero++;
        }
        ans[0] = zero;
        ans[1] = one;
        return ans;
    }
}