package DailyChallenge.ArrayAndHashing.MissingElement;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i <n)
        {
            if (nums[i] < n && nums[i] != i){
                swap(nums, nums[i], i);
            }
            else
                i++;
        }
        for(int j = 0; j < n; j++){
            if(nums[j] != j) return j;
        }
        return n;

    }
    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
