package DailyChallenge.Greedy.MaximumUnitsOnTruck.Approach_2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Comparator<int[]> comp = (a, b) -> b[1] - a[1];
        Arrays.sort(boxTypes, comp);

        for(int[] box : boxTypes){

            int boxNumber = box[0];
            int weight = box[1];

            int boxTaken = Math.min(truckSize, boxNumber);

            ans += boxTaken * weight;
            truckSize -= boxTaken;
            if (truckSize == 0) break;
        }
        return ans;
    }
}