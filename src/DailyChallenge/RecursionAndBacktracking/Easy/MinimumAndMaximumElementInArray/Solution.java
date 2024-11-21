package DailyChallenge.RecursionAndBacktracking.Easy.MinimumAndMaximumElementInArray;

import java.util.Arrays;

// https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/
public class Solution {
    public static void main(String[] args) {
        int[] array = {23,1,5,2,4,8,9,};
        int[] ans = min_Max(array);
        System.out.println(Arrays.toString(ans));
    }
    static int[] min_Max(int[] array){
        int n = array.length;
        int[] ans = new int[2];
        ans[0] = getMin(array, n);
        ans[1] = getMax(array, n);
        return ans;
    }

    private static int getMin(int[] array, int n) {
        if (n == 1){
            return array[0];
        }
        return Math.min(array[n-1], getMin(array, n-1));
    }
    static int getMax(int[] array, int n){
        if (n == 1){
            return array[0];
        }
        return Math.max(array[n-1], getMax(array, n-1));
    }

}
