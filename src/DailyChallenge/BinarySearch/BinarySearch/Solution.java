package DailyChallenge.BinarySearch.BinarySearch;
// https://leetcode.com/problems/binary-search/
class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = (start+end)/2;
            if (target>nums[mid]) {
                start = mid+1;
            } else if (target<nums[mid]) {
                end = mid-1;
            }
            else
                return mid;

        }
        return -1;
    }
}
