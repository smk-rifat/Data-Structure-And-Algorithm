package DailyChallenge.Sorting.CyclicSort.MissingNumber;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
class Solution {
    public static void main(String[] args){

    }
    public static int naiveWay(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = n-1; i >= 0; i--){
            if (nums[i] != n){
                return n;
            } else {
                n--;
            }
        }
        return 0;
        // time complexity O(n log n), cause sorting cost (n log n) and for loop takes n that's why we take (n log n).
    }
    public static int betterWay(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            int index = nums[i];
            if (nums[i] >= n){
                i++;
            }else if(nums[index] != nums[i]){
                swap(nums, index, i);
            }else{
                i++;
            }
        }
        for(int j = 0; j < n; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return n;
        // here time complexity is O(n)
    }
    static void swap(int[] nums, int index, int cur){
        int temp = nums[cur];
        nums[cur] = nums[index];
        nums[index] = temp;
    }
    // here is the optimalOne
    static int missingNumber(int[] nums){
        int n = nums.length;
        int sum = 0;
        int total = (n*(n+1))/2;
        for (int num : nums){
            sum += num;
        }
        return total-sum;
    }
    // here time complexity id O(n) also its optimal than previous one.
}