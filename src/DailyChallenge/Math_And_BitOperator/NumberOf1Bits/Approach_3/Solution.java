package DailyChallenge.Math_And_BitOperator.NumberOf1Bits.Approach_3;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count++;
            mask = mask << 1;
        }
        return count;
    }
}