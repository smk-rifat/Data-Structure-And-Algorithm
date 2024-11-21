package DailyChallenge.RecursionAndBacktracking.Easy.SelectionSort;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        recursiveWay(array, array.length, 1);
        System.out.println(Arrays.toString(array));
    }
    static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            for (int j = i+1; j > 0; j-- ){
                if (nums[j] < nums[j-1]){
                    swap(nums, j , j-1);
                }
            }
        }
    }
    static void recursiveWay(int[] array, int n, int i){
        if (i == n){
            return;
        }
        for(int j = i; j >0; j--){
            if (array[j] < array[j-1]){
                swap(array, j, j-1);
            }
        }
        recursiveWay(array, n, i+1);
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
