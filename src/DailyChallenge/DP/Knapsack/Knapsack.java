// Given a list of N items, and a backpack with a
// limited capacity, return the maximum total profit that 
// can be contained in the backpack. The i-th item's profit
// is profit[i] and it's weight is weight[i]. Assume you can
// only add each item to the bag at most one time. 
package DailyChallenge.DP.Knapsack;

import java.util.Arrays;

public class Knapsack {
    // Brute force Solution
    // Time: O(2^n), Space: O(n)
    // Where n is the number of items.
    public int bruteForce(int[] profit, int[] weight, int capacity){
        return bruteHelper(0, profit, weight, capacity);
    }
    public int bruteHelper(int idx, int[] profit, int[] weight, int capacity){
        if (idx >= profit.length) return 0;

        // skip object
        int max = bruteHelper(idx+1, profit, weight, capacity);
        
        // take the object
        int newCap = capacity - weight[idx];
        if (newCap >= 0) {
            int taken = profit[idx] + bruteHelper(idx+1, profit, weight, newCap);
            max = Math.max(max, taken);
        }

        return max;
    }
    public int memoization(int idx, int capacity, int[] weight, int[] profit){
         int[][] memo = new int[profit.length +1 ][capacity +1];

         for(int[] box : memo){
            Arrays.fill(box, -1);
         }

         return memoHelper(0, capacity, memo, weight, profit);
    }
    public int memoHelper(int idx, int capacity, int[][] memo, int[] weight, int[] profit){
        if (idx >= profit.length) return 0;

        if (memo[idx][capacity] != -1) {
            return memo[idx][capacity];
        }

        
        int skip= memoHelper(idx+1, capacity, memo, weight, profit);
        int include = 0;

        if (capacity >= weight[idx]) {
            include = profit[idx] + memoHelper(idx+1, capacity - weight[idx], memo, weight, profit);
        }
        memo[idx][capacity] = Math.max(include, skip);

        return memo[idx][capacity];
    }
}
