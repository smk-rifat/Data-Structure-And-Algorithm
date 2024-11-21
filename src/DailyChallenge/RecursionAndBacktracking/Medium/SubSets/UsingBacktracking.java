package DailyChallenge.RecursionAndBacktracking.Medium.SubSets;

import java.util.ArrayList;
import java.util.List;

public class UsingBacktracking {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        backtrack(nums, index, ans, temp);
        return ans;
    }
    static void backtrack(int[] nums, int index, List<List<Integer>> ans, List<Integer> list){
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
        }else {
            list.add(nums[index]);
            backtrack(nums, index+1, ans, list);
            list.removeLast();
            backtrack(nums, index+1, ans, list);
        }
    }
}
