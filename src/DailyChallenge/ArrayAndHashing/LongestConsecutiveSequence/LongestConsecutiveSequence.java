package DailyChallenge.ArrayAndHashing.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence
{
    public static void main(String[] args) {
        int[] nums = {0,1,2,49,50,48,47};
        //System.out.println(bruteForce(nums));
        System.out.println(longestConsecutive(nums));
    }
    public static int bruteForce(int[] nums){
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int max = 1;
        int countMax = 0;
        for (int i = 1; i<nums.length; i++){
            if (nums[i] == nums[i-1]+1) countMax++; // checking each element with its previous element
            else if (nums[i] == nums[i-1]) continue; // if its equal then just ignore
            else countMax = 1; // and if they are not equal and interval is not same as before, then start a new sequence
            max = Math.max(countMax, max); // calculate the max length of the sequel
        }
        return max;
        // time complexity is O(nlog(n)+n) = O(nlog(n))
    }
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashMap<Integer, Boolean> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, Boolean.TRUE);
        }
        int count = 0;
        int max = 1;

        for (int num : nums)
        {
               
            if (frequency.get(num)) {
                frequency.put(num, Boolean.FALSE);
                boolean left = true;
                boolean right = true;
                while (left) {
                    int value = num - 1;
                    if (frequency.containsKey(value)) {
                        count++;
                        frequency.put(value, Boolean.FALSE);
                        num = value;
                    } else
                        left = false;
                }
                while (right) {
                    int value = num + 1;
                    if (frequency.containsKey(value)) {
                        count++;
                        frequency.put(value, Boolean.FALSE);
                        num = value;
                    } else
                        right = false;
                }
            }
            max = Math.max(count, max);

        }
        return max;
    }

}
