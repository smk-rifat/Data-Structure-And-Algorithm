package DailyChallenge.RecursionAndBacktracking.Theory.Recursion.Pattern;

public class Triangle1 {
    public static void main(String[] args) {
        triangle2(4,0);
    }
    static void triangle(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        if (n>=1){
            triangle(n-1);
        }
    }
    static void triangle2(int r, int c){
        if (r == 0) return;

        if (c < r){
            System.out.print("* ");
            triangle2(r, c+1);
        }
        else {
            System.out.println();
            triangle2(r-1, 0);
        }
    }
}
