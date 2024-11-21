package DailyChallenge.AdvanceGraph.AlienDictionary.Approach_1;

import java.util.*;

class Solution {
    public String alienOrder(String[] words){

        int[] degree = new int[26];
        Arrays.fill(degree, -1);

        for (String word : words){
            for(char c : word.toCharArray()){
                if (degree[c-'a'] == -1){
                    degree[c-'a'] = 0;
                }
            }
        }

        Map<Character, List<Character>> graph = new HashMap<>();

        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int length = Math.min(word1.length(), word2.length());

            boolean foundDifference = false;
            for (int j = 0; j < length; j++) {
                char a = word1.charAt(j);
                char b = word1.charAt(j);

                if (a != b){
                    graph.putIfAbsent(a, new ArrayList<>());

                    if (!graph.get(a).contains(b)){
                        graph.get(a).add(b);
                        degree[b - 'a']++;
                    }
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && word1.length() > word2.length()){
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0){
               queue.offer((char) (i + 'a'));
            }
        }

        while(!queue.isEmpty()){
            char current = queue.poll();
            ans.append(current);

            if (graph.containsKey(current)){

                for (char neighbor : graph.get(current)){
                    degree[neighbor - 'a'] --;

                    if (degree[neighbor - 'a'] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }

        return ans.toString();
    }
}
