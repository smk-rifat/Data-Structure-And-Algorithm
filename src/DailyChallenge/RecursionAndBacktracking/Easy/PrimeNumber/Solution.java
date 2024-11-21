package DailyChallenge.RecursionAndBacktracking.Easy.PrimeNumber;
// https://www.geeksforgeeks.org/recursive-program-prime-number/
public class Solution {
    public static void main(String[] args) {
       int n = 1;
        System.out.println(isPrimeRecursive(n,2));
    }
    static boolean isPrime(int n){
        int c = 0;
        for (int i = 1; i <= n; i++){
            if (n %i == 0){
                c++;
            }
        }
        return c == 2;
    }
    static boolean isPrimeRecursive(int n, int i){
        if (i == n){
            return true;
        }
        if (n == 1) return false;
        if (n % i == 0){
            return false;
        }
        return isPrimeRecursive(n, i+1);
    }
}
