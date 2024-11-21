package DailyChallenge.Math_And_BitOperator.CountPrimes.Approach_1;

class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        int count = 0;
        for (int i = 3; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
    public boolean isPrime(int n){
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) count++;
        }
        return count == 2;
    }
}