package DailyChallenge.Math_And_BitOperator.NumberOf1Bits.Approach_2;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        while (n != 0){
            if ((n & mask) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
}