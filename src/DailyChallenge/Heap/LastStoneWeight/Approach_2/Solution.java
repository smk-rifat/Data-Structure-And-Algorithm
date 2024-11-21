package DailyChallenge.Heap.LastStoneWeight.Approach_2;

import java.util.PriorityQueue;

class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int s : stones){
            heap.add(-s);
        }
        while (heap.size() > 1){
            int l = -(heap.remove());
            int sL = - (heap.remove());

            int remaining = l -sL;
            if (remaining > 0){
                heap.add(-remaining);
            }
        }
        return heap.isEmpty() ? 0 : -heap.peek();
    }
}