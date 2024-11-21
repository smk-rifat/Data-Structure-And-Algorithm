package DailyChallenge.BinarySearch.MinimumInRotatedSortedArray;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public static void main(String[] args) {
         int[] nums = {3,4,5,6,1,2};
        System.out.println(findMin(nums));
    }
    public static int bruteForce(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        for (int n : nums){
            min = Math.min(min, n);
        }
        return min;
        // time complexity O(n), but we have to do it in O(logN)
    }
    public static int findMin(int[] nums) {
            int start = 0;
            int end = nums.length-1;
            int ans = Integer.MAX_VALUE;

            while(start <= end){
                int mid = (start+end)/2;
                if (nums[start] <= nums[end]){
                    ans = Math.min(ans, nums[start]);
                    break;
                }
                else if(nums[start] <= nums[mid]){
                    ans = Math.min(ans, nums[start]);
                    start = mid+1;
                }
                else if(nums[mid] <= nums[end])
                {
                    ans = Math.min(ans, nums[mid]);
                    end = mid-1;
                }
            }
            return ans;

    }
}
