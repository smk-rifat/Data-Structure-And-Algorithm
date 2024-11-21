package DailyChallenge.ArrayAndHashing.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] bruteForce(int[] nums , int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i]+nums[j] == target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> myBag = new HashMap<>();

        int start = 0;
        int end = nums.length-1;

        while (start<=end)
        {
            int complement = target - nums[start];

            if (myBag.containsKey(complement))
            {
                return new int[]{start, myBag.get(complement)};
            }
            myBag.put(nums[start], start);
            complement = target - nums[end];
            if (myBag.containsKey(complement))
            {
                return new int[]{end, myBag.get(complement)};
            }
            myBag.put(nums[end], end);

            start++;
            end--;
        }
        return new int[]{-1,-1};
    }
}
