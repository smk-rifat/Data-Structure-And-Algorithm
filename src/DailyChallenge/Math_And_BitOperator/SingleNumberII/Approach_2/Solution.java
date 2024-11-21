package DailyChallenge.Math_And_BitOperator.SingleNumberII.Approach_2;

class Solution {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int k = 0; k < 32; k++) {
           int one = 0;
           for(int num : nums){
               int temp = 1 << k;
               if ((num & temp) != 0){
                   one++;
               }
           }

           if (one % 3 != 0){
               result = result | 1 << k;
           }
        }
        return result;
    }
// Tc will always be O(32 * N)
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }
}