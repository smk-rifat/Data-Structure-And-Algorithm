package DailyChallenge.Math_And_BitOperator.PowerOfTwo.Approach_3;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}