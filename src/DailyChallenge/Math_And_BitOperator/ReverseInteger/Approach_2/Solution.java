package DailyChallenge.Math_And_BitOperator.ReverseInteger.Approach_2;

class Solution {
    public static int reverse(int x) {
        // If the number is a single-digit, return it as is
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        // Check if the number is negative

        // Variable to store the reversed number
        int rev = 0;

        // Process each digit
        while (x > 0) {
            // Check for potential overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0; // Return 0 if overflow would occur
            }

            // Update the reversed number by adding the last digit of x
            rev = rev * 10 + (x % 10);

            // Remove the last digit from x
            x /= 10;
        }

        // Return the reversed number with the correct sign
        return isNegative ? -rev : rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
