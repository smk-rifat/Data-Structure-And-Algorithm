package DailyChallenge.ArrayAndHashing.FindTheDuplicateNumber;
// https://leetcode.com/problems/find-the-duplicate-number/description/

public class Solution {
    public static void main(String[] args) {
       int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            int index = nums[i]-1;
            if (nums[i] != nums[index]){
                swap(nums, i, index);
            }else
                i++;
        }
        for (int j = 0; j < n ; j++) {
            if (j != nums[j]-1)
            {
                return nums[j];
            }
        }
        return -1;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
