package DailyChallenge.RecursionAndBacktracking.Medium.PalindromePartitioning;
//
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
        System.out.println(ans);
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        operation(s, list, ans);
        return ans;
    }
    static void operation(String s, List<String> list, List<List<String>> ans){
        if (s.isEmpty()){
            List<String> copyOfList = new ArrayList<>(list);
            ans.add(copyOfList);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String temp = s.substring(0, i+1);
            if (isPalindrome(temp)){
                list.add(temp);
                operation(s.substring(i+1), list, ans);
                list.removeLast();
            }
        }
    }
    static boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l < r){
            if (str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}