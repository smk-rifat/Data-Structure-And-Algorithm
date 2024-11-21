package DailyChallenge.Math_And_BitOperator.ReverseInteger.Approach_1;
// https://leetcode.com/problems/reverse-integer/

class Solution {

    public static int reverse(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);

        int num = 0;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < num) return 0;

            num = 10 * num + x % 10;
            x /= 10;
        }

        return isNegative ? -num : num;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648)); // showing output zero
    }
}
