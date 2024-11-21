package DailyChallenge.Math_And_BitOperator.FindNthMagicNumber;

class Solution {
    public static void main(String[] args) {
        System.out.println(nThMagicNumber(5));
    }
    static int nThMagicNumber(int n){
        int ans = 0;
        int base = 5;

        while (n != 0){
            int last = n & 1;
            ans += last * base;
            base = base * 5;
            n = n >>1;
        }
        return ans;
    }
}
