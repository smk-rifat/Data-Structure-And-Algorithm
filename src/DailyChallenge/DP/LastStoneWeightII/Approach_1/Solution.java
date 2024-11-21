package DailyChallenge.DP.LastStoneWeightII.Approach_1;
// https://leetcode.com/problems/last-stone-weight-ii/

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight = 0;
        for(int s : stones){
            totalWeight += s;
        }
        return bruteForce(stones, 0, totalWeight, 0);
    }
    public int bruteForce(int[] stones, int pile1, int totalWeight, int idx){
        if (idx == stones.length){
            int pile2 = totalWeight - pile1;
            return Math.abs(pile1 - pile2);
        }

        int diff1 = bruteForce(stones, pile1, totalWeight, idx+1);
        int diff2 = bruteForce(stones, pile1+stones[idx], totalWeight, idx+1);

        return Math.min(diff1, diff2);
    }
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        Solution obj = new Solution();
        System.out.println(obj.lastStoneWeightII(stones));

    }
}
