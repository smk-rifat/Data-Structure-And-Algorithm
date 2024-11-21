package DailyChallenge.AdvanceGraph.CheapestFlightsWithinKStops.Approach_1;
// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<Flight>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Flight>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            graph.get(from).add(new Flight(to, cost));
        }

        int[] track = new int[n];
        Arrays.fill(track, Integer.MAX_VALUE);

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));

        while (!queue.isEmpty()) {
            Tuple current = queue.remove();
            int step = current.steps;
            int cost = current.cost;
            int city = current.city;

            if (step > k) continue;

            for(Flight neighbor : graph.get(city)){
                int adjCity = neighbor.toCity;
                int edgeWeight = neighbor.cost;

                if (cost + edgeWeight < track[adjCity]) {
                    track[adjCity] = cost+edgeWeight;
                    queue.add(new Tuple(step+1, adjCity, cost+edgeWeight));
                }
            }
        }
        return track[dst] == Integer.MAX_VALUE ? -1 : track[dst];
    }
   
}
  class Flight {
        int toCity;
        int cost;

        Flight(int toCity, int cost) {
            this.toCity = toCity;
            this.cost = cost;
        }
    }

    // Inner class to represent a tuple in the BFS queue
    class Tuple {
        int steps;
        int city;
        int cost;

        Tuple(int steps, int city, int cost) {
            this.steps = steps;
            this.city = city;
            this.cost = cost;
        }
    }