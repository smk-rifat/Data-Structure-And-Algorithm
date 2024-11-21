package DailyChallenge.Greedy.PartitionLabels.Approach_1;
// https://leetcode.com/problems/partition-labels/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int left = 0, right = 0, pointer = 0;

        while(left < s.length()){
            right = map.get(s.charAt(right));

            if(map.get(s.charAt(left)) > right){
                right = map.get(s.charAt(left));
            }
            if(left == right){
                int length = right - pointer + 1;
                ans.add(length);
                left++;
                right++;
            }else {
                left++;
            }

        }
        return ans;
    }
    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij";
        List<Integer> ans = partitionLabels(s);
        System.out.println(ans);
    }
}