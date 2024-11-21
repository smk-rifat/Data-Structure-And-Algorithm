package DailyChallenge.RecursionAndBacktracking.Easy.BinarySearch;
// https://leetcode.com/problems/binary-search/
class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        return binary(nums, target,s, e);
    }
    static int binary(int[] nums, int target, int s, int e){
        if (s <= e){
            int mid = (s+e)/2;
            if (target == nums[mid]){
                return mid;
            } else if (target > nums[mid]) {
                return binary(nums, target, mid+1, e);
            }
            else
            {
                return binary(nums, target, s, mid-1);
            }
        }
        return -1;
    }
}