package DailyChallenge.Stack.NextGreaterElement_II;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public static void main(String[] args) {
      int[] nums = {1,2,3,4,3};
      System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            stack.push(nums[i]);
        }
        for (int i = n-1; i >=0 ; i--) {
            int curNum = nums[i];
             while (!stack.isEmpty() && curNum >= stack.peek())
             {
                 stack.pop();
             }
             if (!stack.isEmpty())
             {
                 nums[i] = stack.peek();
             }
             else
                 nums[i] = -1;

             stack.push(curNum);
        }
       return nums;
    }
}
