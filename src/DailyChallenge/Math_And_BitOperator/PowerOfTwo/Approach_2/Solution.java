package DailyChallenge.Math_And_BitOperator.PowerOfTwo.Approach_2;

class Solution {
    public boolean isPowerOfTwo(int n) {
        int numberOfBit = (int) (Math.log(n)/ Math.log(2))+1;
        int mask = 1;
        int count = 0;

        for (int i = 0; i < numberOfBit; i++) {
            if ((n & mask) != 0){
                count++;
            }
            if (count > 1) return false;
            mask = mask <<1;
        }

        return count == 1;
    }
}