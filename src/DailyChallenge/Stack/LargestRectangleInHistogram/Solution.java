package DailyChallenge.Stack.LargestRectangleInHistogram;
import java.util.Stack;
class Pair<I, B> {
    private final I index;
    private final B bar;
    Pair(I index, B bar) {
        this.index = index;
        this.bar = bar;
    }
    public I getIndex() {
        return index;
    }
    public B getBar() {
        return bar;
    }

}
public class Solution {
    public static void main(String[] args) {
        int[] heights = {3, 2, 1};
        System.out.println(largestRectangleArea(heights));
    }
// BruteForce
    public static int bruteForce(int[] heights){
        int maxArea = 0;
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> index = new Stack<>();
        int st, cArea, maxArea = 0, i = 0;

        while (i<n){
            int curNum = heights[i];
            if (index.isEmpty() && curNum >= index.peek()){
                index.push(i);
                i++;
            }
            else{
                st = index.pop();
                cArea =(heights[st] * (index.isEmpty()? i: (i-index.peek()-1)));
                maxArea = Math.max(maxArea, cArea);
            }
        }
        while (!index.isEmpty()){
            st = index.pop();
            cArea = (heights[st] * (index.isEmpty()? i:(n-index.peek()-1)));
            maxArea = Math.max(maxArea, cArea);
        }
        return maxArea;
    }

    // pair approach
    public static int pairApproach(int[] heights){
        int n = heights.length;
        int area = 0;
        int start = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i<n; i++) {
            int curHt = heights[i];
            start = i;
            while (!stack.isEmpty() && stack.peek().getBar()> curHt) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.getIndex();
                int h = pair.getBar();
                area = Math.max(area, h*(i-index));
                start = index;
            }
            stack.push(new Pair<>(start, curHt));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int index = pair.getIndex();
            int h = pair.getBar();
            area = Math.max(area, h*(n-index));
        }
        return area;
    }
    public static int leftRightApproach(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int mArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i]< stack.peek()) {
                right[stack.peek()] = heights[i];
                stack.pop();
            }
            if (i >0 && heights[i] == heights[i-1]) {
                left[i-1] = left[i-1];
            }
            left[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int reM = stack.pop();
            right[reM] = n;
        }
        for (int i = 0; i < n; i++) {
            mArea = Math.max(mArea, (right[i] - left[i] -1));
        }
        return mArea;
    }

}
// This creepy problem took 3 days , just to get behind scene of the code