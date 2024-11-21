package DailyChallenge.Heap.KthLargestElementInStream.Approach_1;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums){
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() >k) heap.poll();
        return heap.peek();
    }
}
