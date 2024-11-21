package DailyChallenge.Math_And_BitOperator.NumberOf1Bits.Approach_1;
// https://leetcode.com/problems/number-of-1-bits/
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}