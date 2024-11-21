package DailyChallenge.TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(bruteForce(nums));
    }

    public static List<List<Integer>> bruteForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null); // elements in the list will be sorted by natural order(null);
                        set.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
        // Here time complexity is O(N^3)
    }

    public static List<List<Integer>> betterWay(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {

            Set<Integer> tempSet = new HashSet<>();

            for (int j = i+1; j < n; j++) {

                int third = -(nums[i]+nums[j]);

                if (tempSet.contains(third)) {

                    List<Integer> temp = Arrays.asList(nums[i],nums[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                tempSet.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum(int[] nums) { // here we are taking constant space complexity
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum>0){
                    k--;
                } else if (sum<0) {
                    j++;
                }else
                {
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(triplet);
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                }

            }

        }
        return ans;
    }
}
