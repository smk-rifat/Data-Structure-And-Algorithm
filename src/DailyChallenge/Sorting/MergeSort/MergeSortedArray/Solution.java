package DailyChallenge.Sorting.MergeSort.MergeSortedArray;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = 0;
        while( i < nums1.length && j < nums2.length ){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);
        // time complexity O(m+n)+O(log n) -> log n for sorting at the last
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while( j >= 0){
            if ( i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}