package DailyChallenge.DP.MinimumDifficultyOfAJobSchedule.Memoization;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        Integer[][] memo = new Integer[jobDifficulty.length][d+1];

        return bruteForce(jobDifficulty, 0, d, memo);
    }

    public int bruteForce(int[] jobs, int idx, int daysLeft, Integer[][] memo){
        if (daysLeft == 1) {
            int max = 0;
            for (int i = idx; i < jobs.length; i++) {
                max = Math.max(max, jobs[i]);
            }
            return max;
        }

        if (memo[idx][daysLeft] != null) return memo[idx][daysLeft];

        int maxD = 0;
        int min = Integer.MAX_VALUE;

        for (int i = idx; i <= jobs.length - daysLeft; i++) {
            maxD = Math.max(maxD, jobs[i]);
            int difficulty = maxD + bruteForce(jobs, i+1, daysLeft-1, memo);
            min = Math.min(min, difficulty);
        }

        memo[idx][daysLeft] = min;
        return memo[idx][daysLeft];
    }
    
}
