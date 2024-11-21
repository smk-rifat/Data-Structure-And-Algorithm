package DailyChallenge.RecursionAndBacktracking.Medium.CombinationSumII;
// https://leetcode.com/problems/combination-sum-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> ans = combinationSum2(nums, target);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        combination(candidates, target, ans, list, index);
        return ans;
    }
    static void combination(int[] nums, int target, List<List<Integer>> ans, List<Integer> list, int index){
        if (target == 0){
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
        } else if(index == nums.length || target < 0){
            return;
        } else {
            int cur = nums[index];
            list.add(cur);
            combination(nums, target-cur, ans, list, index+1);
            list.removeLast();
            while(index +1 < nums.length && nums[index] == nums[index+1]) index++;
            combination(nums, target, ans, list, index+1);
        }
    }
}