package DailyChallenge.ArrayAndHashing.FindAllNumbersDisappearsInArray;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < n){
            int index = nums[i]-1;
            if (nums[i] != nums[index]){
                swap(nums, i, index);
            }else
                i++;
        }
        for (int j = 0; j < n ; j++) {
            if (j != nums[j]-1)
            {
                list.add(j+1);
            }
        }
        return list;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
