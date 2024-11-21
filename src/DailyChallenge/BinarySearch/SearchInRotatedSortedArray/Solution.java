package DailyChallenge.BinarySearch.SearchInRotatedSortedArray;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public static void main(String[] args) {
         int[] nums = {4,5,6,7,0,1,2};
         int target = 0;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
         int start = 0;
         int end = nums.length-1;
         int ans = -1;

         while (start <= end)
         {
             int mid = (start+end)/2;
             if (nums[start] <= nums[end])
             {
                 return binarySearch(nums, start, end, target);
             }
             else if (nums[start] <= nums[mid])
             {
                 ans = binarySearch(nums, start, mid, target);
                 if (ans != -1) {
                     return ans;
                 }
                 else
                    start = mid+1;
             }
             else if (nums[mid] <= nums[end])
             {
                 ans = binarySearch(nums, mid, end, target);
                 if (ans != -1)
                 {
                     return ans;
                 }
                 else
                     end = mid-1;
             }
         }
         return 0;
    }
    static int binarySearch(int[] nums, int start, int end, int target)
    {
        int ans = -1;

        while (start <= end)
        {
            int mid = (start+end)/2;
            if (target < nums[mid])
            {
                end = mid-1;
            } else if (target>nums[mid]) {
                start = mid+1;
            }
            else
                return mid;
        }
        return ans;
    }
}