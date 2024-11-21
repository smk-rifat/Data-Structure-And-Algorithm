package DailyChallenge.Math_And_BitOperator.MissingNumber.Approach_1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for (int i = 0; i<= nums.length; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}