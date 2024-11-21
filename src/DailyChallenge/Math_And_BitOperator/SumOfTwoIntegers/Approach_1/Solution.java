package DailyChallenge.Math_And_BitOperator.SumOfTwoIntegers.Approach_1;
// https://leetcode.com/problems/sum-of-two-integers/
class Solution {
    public int getSum(int a, int b) {

        while(b != 0){
            int carry = ((a&b) << 1);
            a = a^b;
            b = carry;
        }
        return a;
    }
}
// The time complexity is O(1) (constant time) due to the following reasons:
//The number of iterations in the loop is determined by the number of bits required to
// represent the numbers.
//Since the problem constraints specify that the integers are between -1000 and 1000, the
// maximum bit length is fixed (10 bits for these integers when using two's complement representation).