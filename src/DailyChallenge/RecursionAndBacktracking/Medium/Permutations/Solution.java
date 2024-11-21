package DailyChallenge.RecursionAndBacktracking.Medium.Permutations;
// https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        helper(nums, ans, list, index);
        return ans;
    }
    static void helper(int[] nums, List<List<Integer>> ans, List<Integer> list, int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        int cur = nums[index];
        for (int i = 0; i <= list.size(); i++) {
            list.add(i, cur);
            helper(nums, ans, list, index+1);
            list.remove(i);
        }
    }
}