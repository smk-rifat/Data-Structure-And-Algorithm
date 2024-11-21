package DailyChallenge.Math_And_BitOperator.HappyNumber.Approach_2;

class Solution {
    public boolean isHappy(int n) {
        int slow = getSquare(n);
        int fast = getSquare(getSquare(n));

        while (slow != fast){
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        }

        return slow == 1;
    }
    public int getSquare(int n){
        int ans = 0;
        while (n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}