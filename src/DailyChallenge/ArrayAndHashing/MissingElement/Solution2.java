package DailyChallenge.ArrayAndHashing.MissingElement;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums){
        int n = nums.length;
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i))
            {
                ans = i;
            }
        }
        return ans;

    }
}
