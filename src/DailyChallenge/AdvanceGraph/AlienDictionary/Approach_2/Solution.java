package DailyChallenge.AdvanceGraph.AlienDictionary.Approach_2;

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> path = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        // build graph
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int length = Math.min(word1.length(), word2.length());

            boolean foundDifference = false;
            for (int j = 0; j < length; j++) {
                char a = word1.charAt(j);
                char b = word2.charAt(j);

                if (a != b){
                    graph.putIfAbsent(a, new HashSet<>());
                    graph.get(a).add(b);
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && word1.length() > word2.length()){
                return "";
            }
        }

        StringBuilder result = new StringBuilder();

        for (char key : graph.keySet()){
            if (!visited.contains(key)){
                if (hasCycle(key, graph, visited, path, result)){
                    return "";
                }
            }
        }

        return result.reverse().toString();
    }

    public boolean hasCycle(Character current,Map<Character, Set<Character>> graph, Set<Character> visited, Set<Character> path, StringBuilder result){
        if (path.contains(current)) return true;
        if (visited.contains(current)) return false;
        path.add(current);

        for (char neighbor : graph.get(current)){
            if (hasCycle(neighbor, graph, visited, path, result)) return true;
        }

        visited.add(current);
        path.remove(current);
        result.append(current);
        return false;
    }

}
