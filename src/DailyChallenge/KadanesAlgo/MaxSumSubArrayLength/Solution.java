package DailyChallenge.KadanesAlgo.MaxSumSubArrayLength;
// https://leetcode.com/problems/longest-turbulent-subarray/submissions/1192864608/
class Solution {
    public static void main(String[] args) {
        int[] nums = {9,4,2,10,7,8,8,1,9};
        int ans = ans(nums);
        System.out.println(ans);
    }
    public static int bruteForce(int[] arr) {
        return 0;
    }
    static int ans(int[] nums){
        int n = nums.length;
        if (n==1) return 1;
        int left = 0;
        int right = 0;
        int max = 1;

        while(right < n-1){
            if (left == right){
                if (nums[left] == nums[left+1]){
                    left++;
                }
                right++;
            } else if(nums[right-1] < nums[right] && nums[right] > nums[right+1] || nums[right-1] > nums[right] && nums[right] < nums[right+1] ){
                right++;
            } else {
                left = right;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
        // something sliding window
    }
}