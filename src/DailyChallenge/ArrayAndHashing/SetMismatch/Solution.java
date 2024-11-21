package DailyChallenge.ArrayAndHashing.SetMismatch;
// https://leetcode.com/problems/set-mismatch/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        int i = 0;
        while(i < n){
            int index = nums[i]-1;
            if(nums[i] != nums[index]){
                swap(nums, i , index);
            }
            else{
                i++;
            }
        }
        for(int j = 0; j <n ; j++){
            if(j != (nums[j] -1)){
                ans[0] = nums[j];
                ans[1] = j+1;
            }
        }

        return ans;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}