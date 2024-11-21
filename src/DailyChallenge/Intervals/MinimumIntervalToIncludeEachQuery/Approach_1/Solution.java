package DailyChallenge.Intervals.MinimumIntervalToIncludeEachQuery.Approach_1;

// https://leetcode.com/problems/minimum-interval-to-include-each-query/
class Solution {
    public static int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int queried = queries[i];
            int temp = Integer.MAX_VALUE;

            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (left <= queried && queried <= right) {
                    temp = Math.min(right - left +1, temp);
                }
            }
            ans[i] = temp;
        }

        return ans;
    }

}