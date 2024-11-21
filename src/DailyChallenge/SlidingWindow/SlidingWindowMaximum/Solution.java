package DailyChallenge.SlidingWindow.SlidingWindowMaximum;
// https://leetcode.com/problems/sliding-window-maximum/
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = bruteForce(nums, k);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] bruteForce(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int l = 0;
        int r = l+k-1;
        int i = 0;
        int a = 0;
        int max = Integer.MIN_VALUE;
        while( i < n){
            if (nums[i] > max) {
                max = nums[i];
            }
            if (i == r) {
                ans[a] = max;
                max = Integer.MIN_VALUE;
                a++;
                l++;
                i = l;
                r = l+k-1;
            } else {
                i++;
            }
            
        }
        return ans;
        // Time complexity O(N^K)
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int a = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k-1) {
                ans[a++] = nums[deque.peekFirst()];
            }
        }
        return ans;
        // time complexity O(N) and space also O(N)
    }
}
