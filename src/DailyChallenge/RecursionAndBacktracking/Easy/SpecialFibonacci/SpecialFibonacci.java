package DailyChallenge.RecursionAndBacktracking.Easy.SpecialFibonacci;

public class SpecialFibonacci {

    public static void main(String[] args) {
         int a = 1;
         int b = 0;
         int n = 7;
        System.out.println(fibonacci(a,b,n));
    }

    // Function to calculate f(n) based on the given algorithm
    private static int fibonacci(int a, int b, int n) {
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else if (n == 2) {
            return a ^ b;
        } else {
            // Using n % 3 to optimize the recursion
            return fibonacci(a, b, n % 3);
        }
    }
}
