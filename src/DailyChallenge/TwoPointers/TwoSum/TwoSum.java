package DailyChallenge.TwoPointers.TwoSum;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum
{
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> bag = new HashMap<>();

        int start = 0;
        int end = nums.length-1;
        while (start<=end)
        {
            int comp = target-nums[start];

            if (bag.containsKey(comp))
            {
                return new int[]{start, bag.get(comp)};
            }
            bag.put(nums[start], start);
            comp = nums[end];
            if (bag.containsKey(comp))
            {
                return new int[]{nums[end], bag.get(comp)};
            }
            bag.put(nums[end], end);
        }
       return new int[]{-1,-1};
    }

}
