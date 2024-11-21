package DailyChallenge.RecursionAndBacktracking.Medium.PhoneNumberCombination;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> result = letterCombinations("9");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return pad(new StringBuilder(), digits);
    }

    static List<String> pad(StringBuilder p, String digits) {
        if (digits.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p.toString());
            return list;
        }

        List<String> ans = new ArrayList<>();
        int d = digits.charAt(0) - '0';

        if (d == 7) {
            int start = (d - 2) * 3;
            int end = ((d - 1) * 3) + 1;
            for (int i = start; i < end; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(new StringBuilder(p).append(ch), digits.substring(1)));
            }
        } else if (d == 9) {
            int start = ((d - 2) * 3) + 1;
            int end = ((d - 1) * 3) + 1;
            for (int i = start; i <= end; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(new StringBuilder(p).append(ch), digits.substring(1)));
            }
        } else if (d == 8) {
            int start = ((d - 2) * 3) + 1;
            int end = (d - 1) * 3 + 1;
            for (int i = start; i < end; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(new StringBuilder(p).append(ch), digits.substring(1)));
            }
        } else {
            int start = ((d - 2) * 3);
            int end = ((d - 1) * 3);
            for (int i = start; i < end; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(new StringBuilder(p).append(ch), digits.substring(1)));
            }
        }
        return ans;
    }
}