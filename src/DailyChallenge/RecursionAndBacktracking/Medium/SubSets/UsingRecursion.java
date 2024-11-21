package DailyChallenge.RecursionAndBacktracking.Medium.SubSets;
import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/subsets/
class UsingRecursion {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        List<List<Integer>> ans = subsets(array);
        System.out.println(ans);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        sets(nums, temp, index, ans);
        return ans;
    }
    static void sets(int[] nums, List<Integer> list, int index, List<List<Integer>> ans){
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        int cur = nums[index];
        List<Integer> listWithCur = new ArrayList<>(list);
        listWithCur.add(cur);
        sets(nums, listWithCur, index+1, ans);
        sets(nums, list, index+1, ans);
    }
}