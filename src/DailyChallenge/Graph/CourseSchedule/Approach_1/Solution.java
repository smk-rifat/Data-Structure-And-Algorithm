package DailyChallenge.Graph.CourseSchedule.Approach_1;

import java.util.*;

// https://leetcode.com/problems/course-schedule/solutions/3756938/beat-s-100-topo-c-java-python-beginner-friendly/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Returns true if there are no cycles in the course dependency graph
        return !isCyclic(prerequisites, numCourses);
    }
    public Map<Integer, Set<Integer>> courseGraph(int[][] preReq, int numOfCourses){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        if (preReq == null) return graph;
        for (int course = 0; course < numOfCourses; course++) {
            graph.put(course, new HashSet<>());
        }
        for(int[] pre : preReq){
            graph.get(pre[0]).add(pre[1]);
        }
        return graph;
    }
    public boolean isCyclic(int[][] preReq, int numOfCourses){
        Map<Integer, Set<Integer>> graph = courseGraph(preReq, numOfCourses);
        Queue<Integer> queue = new LinkedList<>();
        for(int course : graph.keySet()){
            if (graph.get(course).isEmpty()){
                queue.add(course);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            for (int key :  graph.keySet()) {
                if (graph.get(key).contains(course)){
                    graph.get(key).remove(course);
                    if (graph.get(key).isEmpty()){
                        queue.add(key);
                    }
                }
            }
        }
        for (Set<Integer> pre : graph.values()){
            if (!pre.isEmpty()) return true;
        }
        return false;
    }

}