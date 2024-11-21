package DailyChallenge.ArrayAndHashing.GroupAnagram;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagram {
    public static void main(String[] args) {
        String[] strings = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> ans = bruteForce(strings);

        System.out.println(ans);
    }

    public static List<List<String>> bruteForce(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);

                for (int j = i + 1; j < strs.length; j++) {
                    if (!visited[j] && isAnagram(strs[i], strs[j])) {
                        group.add(strs[j]);
                        visited[j] = true;
                    }
                }
                ans.add(group);
            }
            visited[i] = true;
        }
        return ans;
    }

    public static boolean isAnagram(String str1, String str2)
    {
        if(str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            if (!map.containsKey(str2.charAt(i)) || map.get(str2.charAt(i)) == 0) {
                return false;
            }
            map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
        }
        return true;
    }
    // for bruteForce overall time complexity is O(n^2*m)
    public static List<List<String>> betterWay(String[] strs)
    {
       Map<String, List<String>> map = new HashMap<>();

       for (String word: strs) {
           char[] c = word.toCharArray();
           Arrays.sort(c);
           String sortedWord = String.valueOf(c);
           if (!map.containsKey(sortedWord)) {
               map.put(sortedWord, new ArrayList<>());
           }
           else {
               map.get(sortedWord).add(word);
           }

       }
    return new ArrayList<>(map.values());
        // Time complexity is O(n*mlog(m)) , n is the length of the input array, m is the average length of the string
    }
    public List<List<String>> optimalWay(String[] strs) // using the frequency of each character in a String
    { // incomplete
        if ( strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }
        Map<String, List<String>> sortingAnagram = new HashMap<>();

        for (String str : strs)
        {
            String frequency = getFrequencyString(str);
            if (!sortingAnagram.containsKey(frequency))
            {
                sortingAnagram.put(frequency, new ArrayList<>());
            }
            else
                sortingAnagram.get(frequency).add(str);
        }
        return new ArrayList<>(sortingAnagram.values());
    }
    public static String getFrequencyString(String strs)
    {
        int[] freq = new int[26];

        for (char c : strs.toCharArray())
        {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int count : freq)
        {
            sb.append(c);
            sb.append(count);
            c++;
        }
        return sb.toString();
    }
}
