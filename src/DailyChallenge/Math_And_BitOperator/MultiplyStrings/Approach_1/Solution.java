package DailyChallenge.Math_And_BitOperator.MultiplyStrings.Approach_1;
// https://leetcode.com/problems/multiply-strings/description/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] digit = new int[m+n];

        for (int i = n-1; i >= 0 ; i--) {
            int d1 = num2.charAt(i) - '0';

            for (int j = m-1; j >= 0 ; j--) {
                int d2 = num1.charAt(j) - '0';
                digit[i+j+1] += d1 * d2;
            }
        }

        for (int i = digit.length-1; i > 0 ; i--) {
            digit[i-1] += digit[i]/10;
            digit[i] %= 10;
        }

        StringBuilder ans = new StringBuilder();
        int start = digit[0] == 0 ? 1 : 0;

        for (int i = start; i < digit.length; i++) {
            ans.append(digit[i]);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "124";
        Solution obj = new Solution();
        System.out.printf(obj.multiply(num1, num2));
    }
}
