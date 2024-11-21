package DailyChallenge.RecursionAndBacktracking.Medium.CombinationSum;
// https://leetcode.com/problems/combination-sum/description/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] array = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum(array, target);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        sumList(candidates, target, 0, ans, temp);
        return ans;
    }
    static void sumList(int[] array, int target, int index, List<List<Integer>> ans, List<Integer> temp){
        if (target == 0){
            ans.add(new ArrayList<>(temp));
        }else if (target < 0 || index >= array.length) {
            return;
        }else {
            temp.add(array[index]);
            sumList(array, target-array[index], index, ans, temp);
            temp.removeLast();
            sumList(array, target, index+1, ans,temp);
        }
    }


}
