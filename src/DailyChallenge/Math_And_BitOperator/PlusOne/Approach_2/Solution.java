package DailyChallenge.Math_And_BitOperator.PlusOne.Approach_2;

import java.util.Arrays;

// https://leetcode.com/problems/plus-one/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n-1; i >= 0 ; i--) {
            digits[i]++;
            if (digits[i] <= 9){
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(obj.plusOne(digits)));
    }
}