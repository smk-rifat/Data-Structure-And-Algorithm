package DailyChallenge.TwoPointers.SumIndices;

import java.util.Arrays;
import java.util.HashMap;

// Given an array of integers which is sorted, return indices of two element which sum is equal to target
public class SumIndices
{
    public static void main(String[] args)
    {
        int[] nums = {-1,2,3,4,8,9};
        System.out.println(Arrays.toString(usingTwoPointer(nums, 7)));
    }
    public static int[] bruteForce(int[] nums, int target){
        int[] ans = {-1,-1};
        for (int i = 0; i< nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return ans;
        // here time complexity is O(n^2)
    }
    public static int[] usingSet(int[] nums, int target)
    {
        int n = nums.length;
        if (n == 0) return null;
        int[] ans = {-1,-1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp))
            {
                return new int[] {i, map.get(comp)};
            }
        }
        return ans;
        // O(n)
    }
    public static int[] usingTwoPointer(int[] nums, int target)
    {
       int[] ans = new int[2];
       int l = 0;
       int r = nums.length-1;

       while (l<r)
       { // for sorted array only
           int current = nums[l]+nums[r];
           if (current> target) // here num[r] is the highest value in the array cause its sorted
           {
               r--;
           } else if (current<target) { // here num[l] is the smallest value in the array,
               // if the sum is less than target that's mean we need something bigger than this and that is after that num[l]
               l++;
           }
           else if (nums[l]+nums[r] == target)
           {
               ans[0] = l;
               ans[1] = r;
               break;
           }

       }
       return ans;
       // time complexity is O(n)
    }
}
