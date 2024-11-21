package DailyChallenge.DP.LongestIncreasingSubsequence.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer> subsequence = new ArrayList<>();

        for (int num : arr) {
            int position = Collections.binarySearch(subsequence, num);

            if (position < 0) {
                position = -position - 1;
            }

            if (position == subsequence.size()) {
                subsequence.add(num);
            } else {
                subsequence.set(position, num);
            }
        }

        return subsequence.size();
    }
}
