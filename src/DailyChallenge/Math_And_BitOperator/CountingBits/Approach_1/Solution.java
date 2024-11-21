package DailyChallenge.Math_And_BitOperator.CountingBits.Approach_1;

import java.util.Arrays;

// https://leetcode.com/problems/counting-bits/
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }
        return ans;
    }
    public int countSetBits(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 5;
        System.out.println(Arrays.toString(obj.countBits(n)));
    }
}