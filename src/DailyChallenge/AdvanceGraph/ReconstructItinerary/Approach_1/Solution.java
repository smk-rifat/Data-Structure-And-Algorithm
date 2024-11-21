package DailyChallenge.AdvanceGraph.ReconstructItinerary.Approach_1;
// https://leetcode.com/problems/reconstruct-itinerary/
import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();
        for(List<String> list : tickets){
            String from = list.get(0);
            String to = list.get(1);
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        visit(map, ans, "JFK");
        return ans;
    }
    private void visit(Map<String, PriorityQueue<String>> map, LinkedList<String> itinerary, String currentFlight){

        PriorityQueue<String> destination = map.getOrDefault(currentFlight, new PriorityQueue<>());

        while (!destination.isEmpty()){
            String next = destination.poll();
            visit(map, itinerary, next);
        }
        itinerary.addFirst(currentFlight);
    }
    public static void main(String[] args) {

    }
}