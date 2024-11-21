package DailyChallenge.AdvanceGraph.ReconstructItinerary.Approach_2;

import java.util.*;

class Solution {

    public List<String> findItinerary(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for(List<String> list: tickets){
            String from = list.get(0);
            String to = list.get(1);
            map.computeIfAbsent(from, k-> new PriorityQueue<>()).add(to);
        }

        stack.push("JFK");

        while (!stack.isEmpty()){
            String current = stack.pop();
            PriorityQueue<String> destination = map.getOrDefault(current, new PriorityQueue<>());

            if (!destination.isEmpty()){
                String next = destination.poll();
                stack.push(next);
            } else {
               ans.addFirst(stack.pop());
            }
        }
        return ans;
    }
}
