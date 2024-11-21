package DailyChallenge.Math_And_BitOperator.PlusOne.Approach_1;

import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
       BigInteger num = BigInteger.ZERO;
       for(int n : digits){
           num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(n));
       }
       num = num.add(BigInteger.ONE);
       int length = num.toString().length();

       int[] ans = new int[length];

        for (int i = length-1; i >= 0 ; i--) {
            ans[i] = num.mod(BigInteger.TEN).intValue();
            num = num.divide(BigInteger.TEN);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.plusOne(digits)));
    }
}