package DailyChallenge.ArrayAndHashing.ProductOfArrayExceptSelf;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArray
{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] bruteForce(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j <n ; j++) {
                if (i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        return ans;
    }
    public static int[] optimalWay(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];
        int prefixAndSuffix = 1; // left most and right most is 1, cause there is no prefix before index 0 and suffix after n

        for (int i = 0; i < n; i++) { // suffix product
            ans[i] = prefixAndSuffix;
            prefixAndSuffix *= ans[i];
        }
        prefixAndSuffix = 1;
        for (int i = n-1; i >=0 ; i--) {
            ans[i] *= prefixAndSuffix;
            prefixAndSuffix *= nums[i];
        }
        return ans;
    }
    public static int[] productExceptSelf(int[] nums) { // this noob solution came up by myself
        int n = nums.length;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[n];
        int product = 1;
     
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            left[i] = product;
        }
        
        product = 1;
        for (int i = n-1; i >= 0; i--) {
            product *= nums[i];
            right[i] = product;
        }

        for (int i = 0; i < n; i++) {
            if (i == n-1)
            {
                ans[i] = left[i-1];
            } else if (i == 0) {
                ans[i] = right[i+1];
            }
            else
                ans[i] = right[i+1]*left[i-1];
           
        }
        return ans;
        
    }
}
