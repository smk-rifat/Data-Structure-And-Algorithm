package DailyChallenge.ArrayAndHashing.FindAllNumbersDisappearsInArray;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?tab=Description
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int j = 1; j<= n; j++){
            if(!set.contains(j)){
                list.add(j);
            }
        }
        return list;
    }
}