package DailyChallenge.Math_And_BitOperator.CountPrimes.Approach_2;

class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n/2];
        int count = n/2;
        for (int currentPrime = 3; currentPrime * currentPrime < n; currentPrime = currentPrime +2) {
              if (!isPrime[currentPrime/2]){
                  for (int multiple = currentPrime * currentPrime; multiple < n; multiple += currentPrime * 2) {
                      if (!isPrime[multiple/2]){
                          isPrime[multiple/2] = true;
                          count--;
                      }
                  }
              }
            }

        return count;
    }
}