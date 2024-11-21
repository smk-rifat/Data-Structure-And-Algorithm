package DailyChallenge.ArrayAndHashing.FirstMissingPositive;

// https://leetcode.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int c = 0;

        while( c < n){
            if(nums[c] > 0 && nums[c] < n){
                int index = nums[c] -1;
                if(nums[c] != nums[index]){
                    swap(nums, c, index);
                }
                else{
                    c++;
                }
            }
            else{
                c++;
            }
        }
        for(int index = 0; index<n; index++){
            int element = nums[index];
            if(index != element-1){
                return index+1;
            }
        }
        return n+1;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}