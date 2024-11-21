package DailyChallenge.Math_And_BitOperator.Theory.FindUnique;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,2,1,3,6,4};
        System.out.println("Ans1 ->" +helper1(nums)+"  "+ "Ans2 ->"+ helper2(nums));
    }
    public static int helper1(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int n : map.keySet()){
            if(map.get(n) == 1){
                return n;
            }
        }
        return -1;
    }
    public static int helper2(int[] nums){
        int unique = nums[0];
        for (int i = 1; i < nums.length; i++) {
            unique ^= nums[i];
        }
        return unique;
    }
}
