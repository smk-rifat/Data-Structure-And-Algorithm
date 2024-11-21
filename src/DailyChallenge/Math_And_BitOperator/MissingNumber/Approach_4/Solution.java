package DailyChallenge.Math_And_BitOperator.MissingNumber.Approach_4;

class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i <= nums.length ; i++) {
            ans = ans ^i;
        }
        for(int n : nums){
            ans = ans ^ n;
        }

        return ans;
    }
}