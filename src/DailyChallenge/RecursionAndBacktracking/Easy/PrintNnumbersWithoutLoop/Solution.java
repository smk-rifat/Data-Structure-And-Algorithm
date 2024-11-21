package DailyChallenge.RecursionAndBacktracking.Easy.PrintNnumbersWithoutLoop;

public class Solution {
    public static void main(String[] args) {
        print(5);
    }
    static void print(int n){
        if ( n == 1){
            System.out.println(n);
            return;
        }
        print(n-1);
        System.out.println(n);
    }
}
