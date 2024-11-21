package DailyChallenge.Graph.CourseSchedule.Approach_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            map.put(course, new HashSet<>());
        }
        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int entry : map.keySet()){
            Set<Integer> visited = new HashSet<>();
            if (hasCycle(map, visited,entry)) return false;
        }
        return true;
    }
    public boolean hasCycle(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int cur){
        if (visited.contains(cur)) return true;
        if (graph.get(cur).isEmpty()) return false;

        visited.add(cur);
        for (int pre : graph.get(cur)){
            if (hasCycle(graph, visited, pre)) return true;
        }
        visited.remove(cur);
        graph.put(cur, new HashSet<>());
        return false;
    }
}
