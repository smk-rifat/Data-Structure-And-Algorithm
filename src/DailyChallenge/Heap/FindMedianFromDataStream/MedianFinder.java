package DailyChallenge.Heap.FindMedianFromDataStream;
import java.util.PriorityQueue;
import java.util.Queue;
// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    Queue<Integer> smallHeap;
    Queue<Integer> largerHeap;
    public MedianFinder(){
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largerHeap = new PriorityQueue<>();
    }
    public void addNum(int num){
       smallHeap.add(num);
       if (!smallHeap.isEmpty() && !largerHeap.isEmpty() && smallHeap.peek() > largerHeap.peek()){
           largerHeap.add(smallHeap.poll());
       }

       if (smallHeap.size() > largerHeap.size() + 1){
           largerHeap.add(smallHeap.poll());
       }
       if (largerHeap.size() > smallHeap.size() + 1){
           smallHeap.add(largerHeap.poll());
       }
    }
    public double findMedian(){
         if (smallHeap.size() == largerHeap.size()) return smallHeap.isEmpty() ? 0.0 : (double) (smallHeap.peek() + largerHeap.peek())/ 2.0;
         else if (smallHeap.size() > largerHeap.size()){
             return (double) smallHeap.peek();
         } else
             return largerHeap.peek();
    }

    public static void main(String[] args) {

    }
}
