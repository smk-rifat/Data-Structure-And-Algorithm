package DailyChallenge.BinarySearch.MedianOfTwoSortedArrays;

public class Solution {
    public static void main(String[] args) {
          int[] nums1 = {1,3};
          int[] nums2 = {2,4};
          System.out.println(bruteForce(nums1, nums2));
    }
    // here is the approach that i came up at first
    public static double bruteForce(int[] nums1, int[] nums2){
         int[] sorted = merge(nums1, nums2);
         int n = sorted.length;
         double ans = 0.0;
         if(n % 2 == 0){
            int p = sorted[(n/2)-1];
            int q = sorted[(n/2)];
            ans = (p+q)/2.0;
         } else {
            ans = sorted[n/2];
         }
         return ans;
    }
    static int[] merge(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                ans[k] = nums1[i];
                i++;
                k++;
            } else{
                ans[k] = nums2[j];
                k++;
                j++;
            }
        }
        
        while (i < n1 || j < n2) {
            if (i < n1) {
                ans[k] = nums1[i];
                i++;
                k++;
            }
            if (j < n2) {
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }
        return ans;
    }
    // here time and space complexity is both O(m+n), but we have to solve it in O(log(m+n)) lets try.....
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        if( n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        double ans = 0.0;
        while( low <= high){
            int partitionNum1 = (low+high)/2;
            int partitionNum2 = ((n1+n2)/2) - partitionNum1;
            int l1 = (partitionNum1 > 0) ? nums1[partitionNum1-1] : Integer.MIN_VALUE;
            int r1 = (partitionNum1 < n1) ? nums1[partitionNum1] : Integer.MAX_VALUE;
            int l2 = (partitionNum2 > 0) ? nums2[partitionNum2-1] : Integer.MIN_VALUE;
            int r2 = (partitionNum2 < n2) ? nums2[partitionNum2] : Integer.MAX_VALUE;

            if(l1 > r2){
                high = partitionNum1 -1;
            } else if( l2 > r1){
                low = partitionNum1+1;
            } else {
                if ((n1+n2) % 2 == 0){
                   ans = (Math.max(l1,l2)+ Math.min(r1, r2))/2.0;
                } else {
                    ans = Math.min(r1, r2);
                }
                break;
            }
        }
        return ans;
        // here time complexity is log (m+n) and constant space complexity , used binary search without taking extra space
    }
}
