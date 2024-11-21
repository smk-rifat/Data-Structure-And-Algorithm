package DailyChallenge.Math_And_BitOperator.MissingNumber.Approach_2;

class Solution {
    public int missingNumber(int[] nums) {
        int index = 0;
        int n = nums.length;
        while (index < n){
            if (nums[index] >= n){
                index++;
            } else if (nums[index] == index){
                index++;
            } else {
              swap(nums, index, nums[index]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return -1;
    }
    public void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(obj.missingNumber(nums));
    }
}