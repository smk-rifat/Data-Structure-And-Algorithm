package DailyChallenge.Sorting.MergeSort.SortAnArray;
// https://leetcode.com/problems/sort-an-array/
class Solution {
    public int[] sortArray(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        mergeSort(nums, s, e);
        return nums;
    }
    static int[] mergeSort(int[] array, int s, int e){
        if(s != e){
            int m = (s+e)/2;
            mergeSort(array, s, m);
            mergeSort(array, m+1, e);
            merge(array, s, m, e);
        }
        return array;
    }
    static void merge(int[] array, int s, int m, int e){
        int l1 = m-s+1;
        int l2 = e-m;

        int[] left = new int[l1];
        int[] right = new int[l2];

        int l = 0;
        int r = 0;
        int a = s;

        for(int i = 0; i<l1; i++){
            left[i] = array[s+i];
        }
        for(int i = 0; i < l2; i++){
            right[i] = array[m+1+i];
        }
        
        while(l < l1 && r < l2){
            if(left[l] <= right[r]){
                array[a] = left[l];
                l++;
            }
            else{
                array[a] = right[r];
                r++;
            }
            a++;
        }
        while(l < l1){
            array[a] = left[l];
            l++;
            a++;
        }
        while(r < l2){
            array[a] = right[r];
            r++;
            a++;
        }
    }
}