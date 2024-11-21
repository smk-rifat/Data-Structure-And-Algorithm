package DailyChallenge.RecursionAndBacktracking.Easy.ReverseString;
// https://leetcode.com/problems/reverse-string/
class Solution {
    public static void main(String[] args) {
         char[] array = {'a','b','c'};
         reverseString(array);
        System.out.println(array);
    }
    public static void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
    static void reverse(char[] s, int l, int r){
        if (l == r){
            return;
        }
        swap(s, l, r);
        reverse(s, l+1, r-1);
    }
    static void swap(char[] array, int l, int r){
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}