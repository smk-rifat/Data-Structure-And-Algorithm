package DailyChallenge.RecursionAndBacktracking.Easy.RecursiveBubbleSort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/recursive-bubble-sort/
public class Solution {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        recursiveWay(array, array.length);
        System.out.println(Arrays.toString(array));
    }
    static void bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
               if (nums[j] > nums[j+1]){
                   swap(nums, j, j+1);
               }
            }
        }
    }
    static void recursiveWay(int[] nums, int n){
        if (n == 1){
            return;
        }
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] > nums[i+1]){
                swap(nums, i, i+1);
                count++;
            }
        }
        if (count == 0){
            return;
        }
        recursiveWay(nums, n-1);
    }
    static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
