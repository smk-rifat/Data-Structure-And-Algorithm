package DailyChallenge.DP.LastStoneWeightII.Approach_2;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight = 0;
        for(int s : stones){
            totalWeight += s;
        }
        int halfSum = totalWeight/2;
        Integer[][] memo = new Integer[stones.length][halfSum+1];
        return memoization(stones, 0, totalWeight,halfSum, 0, memo);
    }
    public int memoization(int[] stones, int pile1, int totalWeight, int halfSum,int idx, Integer[][] memo){
        if (idx == stones.length) {
            int pile2 = totalWeight - pile1;
            return Math.abs(pile1 - pile2);
        }

        if (memo[idx][pile1] != null) return memo[idx][pile1];
        int diff1 = Integer.MAX_VALUE;

        if (pile1 + stones[idx] <= halfSum) {
            diff1 = memoization(stones, pile1+stones[idx], totalWeight, halfSum, idx+1, memo);
        }
        int diff2 = memoization(stones, pile1+stones[idx], totalWeight, halfSum, idx+1, memo);
        int result = Math.min(diff1, diff2);
        memo[idx][pile1] = result;
        return result;
    }
}