import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public void Lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);
        Arrays.fill(dp, -1);

        int maxIndex = 0;
        int ovMax = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (max < dp[j]) {
                        max = dp[j];
                        prev[i] = j;
                    }
                }
            }
            dp[i] = max + 1;
            if (ovMax < dp[i]) {
                ovMax = dp[i];
                maxIndex = i;
            }
        }

        System.out.println("Length of the LIS is: " + ovMax);
        System.out.println("Here is the LIS: ");
        printL(nums, prev, maxIndex);
        dp[maxIndex] = 0;
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == ovMax) {
                maxIndex = i;
            }
        }
        printL(nums, prev, maxIndex);
    }

    public void printL(int[] nums, int[] prev, int idx) {
        List<Integer> list = new ArrayList<>();

        while (idx != -1) {
            list.add(nums[idx]);
            idx = prev[idx];
        }
        Collections.reverse(list);
        System.out.println(list);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        obj.Lis(nums);
    }
}

