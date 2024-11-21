package DailyChallenge.RecursionAndBacktracking.Medium.SubSetsII;
// https://leetcode.com/problems/subsets-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> ans = subsetsWithDup(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);
        sets(nums, ans, list, index);
        return ans;
    }
    static void sets(int[] nums, List<List<Integer>> ans, List<Integer> list, int index){
         if (index == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        } else {
            int cur = nums[index];
            list.add(cur);
            sets(nums, ans, list, index+1);
            list.removeLast();
            while (index+1 < nums.length && nums[index] == nums[index+1]) index++; // here ignoring the duplicate element
            sets(nums, ans, list, index+1);
        }
    }
    // at worst case time complexity is still O(2^n)
}