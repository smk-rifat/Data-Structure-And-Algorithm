package DailyChallenge.DP.SuperEgg.Memoization;
// https://leetcode.com/problems/super-egg-drop/
class Solution {
    Integer[][] memo;

    public int superEggDrop(int e, int f) {
        // Initialize memoization table
        memo = new Integer[e + 1][f + 1];
        return memoization(e, f);
    }

    private int memoization(int e, int f) {
        // Base cases
        if (f == 0 || f == 1)
            return f;
        if (e == 1)
            return f;

        // Check if the result is already computed
        if (memo[e][f] != null)
            return memo[e][f];

        int low = 1, high = f, attempt = Integer.MAX_VALUE;

        // Using binary search to minimize the worst-case attempts
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int breakCase = memoization(e - 1, mid - 1); // Egg breaks
            int notBreakCase = memoization(e, f - mid); // Egg doesn't break

            // We need the worst-case scenario so take the maximum
            int worstCase = 1 + Math.max(breakCase, notBreakCase);

            // Minimize the number of attempts
            attempt = Math.min(attempt, worstCase);

            // Adjust search range
            if (breakCase > notBreakCase) {
                high = mid - 1; // Egg breaks, search lower floors
            } else {
                low = mid + 1; // Egg doesn't break, search higher floors
            }
        }

        // Save the result in the memo table
        memo[e][f] = attempt;
        return attempt;
    }
}
