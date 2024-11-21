package DailyChallenge.Stack.NextGreaterElement_O;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,2,7,4,8};
        System.out.println(Arrays.toString(sickWay(nums)));
    }
    public static int[] bruteForce(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            int value = nums[i];
            for (int j = i+1; j < n; j++) {
                if (value<nums[j]) {
                    ans[i] = nums[j];
                    break;
                }

            }

        }
        return ans;
    }
    public static int[] stackApproach(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--)
        {
            int curNum = nums[i];
            ans[i] = 1;
            while (!stack.isEmpty() && curNum> stack.peek()) // finding greater element for curNum
            {
                stack.pop();
            }
            if (!stack.isEmpty())
            {
                ans[i] = stack.peek();
            }
            stack.push(curNum);
        }
        return ans;
    }
    public static int[] sickWay(int[] nums) {
      int n = nums.length;
      int[] ans = new int[n];
      HashMap<Integer, Integer> map = new HashMap<>();
      int largest = Integer.MIN_VALUE;

        for (int i = n-1; i >=0 ; i--) {
            ans[i] = -1;
            int curNum = nums[i];
            if (curNum>largest)
            {
                largest = curNum;
                map.put(curNum, -1);
                continue;
            }
            int index = 1;
            int br = 0;

            while (nums[i+index] < curNum) {
                 br = map.get(nums[i+index]);
                 if (br != -1) {
                     index += br;
                 }
                 else
                     break;
            }
            ans[i] = nums[i+index];
            map.put(curNum, index);
        }
        return ans;
    }
}

