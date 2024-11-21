class Solution {
    public static int findCatalan(int n) {
        return catalan(n);
    }
    public static int catalan(int n) {
        if (n == 1 || n == 0)
            return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int left = catalan(i - 1);
            int right = catalan(n - i);

            sum += left * right;
        }
        return sum;
    }
}
