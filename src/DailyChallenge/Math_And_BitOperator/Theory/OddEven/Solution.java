package DailyChallenge.Math_And_BitOperator.Theory.OddEven;

public class Solution {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(isOdd(n));
    }
    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
