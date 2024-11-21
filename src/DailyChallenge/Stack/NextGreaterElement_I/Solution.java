package DailyChallenge.Stack.NextGreaterElement_I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/description/
// Solve it before Daily Temperature
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
    public static int[] bruteForce(int[] nums1, int[] nums2) {
        //  ha ha!! this is called extreme brute Force
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];

        for (int i = 0; i <n1 ; i++) { // traversing the nums1 array
            for (int j = 0; j < n2; j++) { // traversing nums2 array
                if (nums1[i] == nums2[j]) { // finding value from nums 1 to nums 2
                    for (int k = j+1; k < n2; k++) { // finding the next greater element
                        if (nums2[j]<nums2[k]) {
                            ans[i] = nums2[k];
                            break;
                        }
                        else
                            ans[i] = -1;
                    }
                }

            }
        }
        return ans;
        // Time complexity is O(n1*n2^2)
        // space O(n) -> auxiliary space int[] ans
    }
    public static int[] betterWay(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        int[] ans = new int[x];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < y; i++) {
          map.put(nums2[i], i);
        }

        for (int i = 0; i < x; i++) {
            ans[i] = -1;
            int index = map.get(nums1[i]);
            for (int j = index; j < y; j++) {
                if (nums2[j]>nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
        // here time complexity is O(x*y)
        // space O(x)
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num: nums2) {
            while (!stack.isEmpty() && num>stack.peek()) { // this loop makes the stack in increasing order
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int i = 0;
        for (int num : nums1) {
            ans[i++] = map.getOrDefault(num, -1);
        }
        return ans;
    }
}
