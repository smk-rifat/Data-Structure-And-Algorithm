package DailyChallenge.Math_And_BitOperator.MissingNumber.Approach_3;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
        }
        for(int n : nums){
            sum -= n;
        }
        return sum;
    }
}