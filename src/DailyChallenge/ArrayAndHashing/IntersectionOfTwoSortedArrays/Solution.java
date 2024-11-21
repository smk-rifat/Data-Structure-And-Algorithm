package DailyChallenge.ArrayAndHashing.IntersectionOfTwoSortedArrays;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        List<Integer> list = new ArrayList<>();
        for(int n : nums2){
            if (set.contains(n)){
                list.add(n);
                set.remove(n);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}