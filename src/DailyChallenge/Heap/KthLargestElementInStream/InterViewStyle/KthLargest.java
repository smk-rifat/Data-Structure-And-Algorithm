package DailyChallenge.Heap.KthLargestElementInStream.InterViewStyle;

class KthLargest {
    int[] minHeap;
    int k;
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void heapify(int[] minHeap, int idx){
        while (true){
            int leftChild = 2 * idx +1;
            int rightChild = 2 * idx + 2;
            int smallChild = idx;
            if (leftChild < minHeap.length && minHeap[leftChild] < minHeap[smallChild]) smallChild = leftChild;
            if (rightChild < minHeap.length && minHeap[rightChild] < minHeap[smallChild]) smallChild = rightChild;

            if (smallChild != idx){
                swap(minHeap, smallChild, idx);
                idx = smallChild;
            } else break;
        }
    }
    public void addInHeap(int[] minHeap, int val){
        if (val > minHeap[0]){
            minHeap[0] = val;
            heapify(minHeap, 0);
        }
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new int[k];
        for(int i = 0; i<k; i++) {
            minHeap[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i<k&&i<nums.length; i++) {
            minHeap[i] = nums[i];
        }
        for(int i = minHeap.length/2; i>=0; i--) {
            heapify(minHeap, i);
        }
        for(int i = k; i<nums.length; i++) {
            addInHeap(minHeap, nums[i]);
        }
    }
    
    public int add(int val) {
        addInHeap(minHeap, val);
        return minHeap[0];
    }
}