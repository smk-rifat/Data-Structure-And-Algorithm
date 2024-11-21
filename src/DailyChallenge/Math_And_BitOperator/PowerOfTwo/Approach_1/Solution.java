package DailyChallenge.Math_And_BitOperator.PowerOfTwo.Approach_1;
// https://leetcode.com/problems/power-of-two/
class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        int base = 2;
        boolean found = false;

        while (!found){
            if (base == n){
                found = true;
            } else if (base > n) {
                break;
            } else {
                base = base *2;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1073741825));
    }
}