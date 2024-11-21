package DailyChallenge.KadanesAlgo.MaxiMumSubArraySum;
// https://leetcode.com/problems/maximum-subarray/description/
class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = optimal(nums);
        System.out.println(ans);
    }
    public static int bruteForce(int[] nums) { // time complexity is O(n^2)
       int maxSum = Integer.MIN_VALUE;
       int n = nums.length;

       for(int i = 0; i < n; i++ ){
        int curSum = 0;
        for(int j = i; j< n; j++){
            curSum += nums[j];
            maxSum = Math.max(maxSum, curSum);
        }
       }
       return maxSum;
    }
    static int optimal(int[] nums){ // kadanes algorithm
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
        // here time complexity is O(n)
    }
}
