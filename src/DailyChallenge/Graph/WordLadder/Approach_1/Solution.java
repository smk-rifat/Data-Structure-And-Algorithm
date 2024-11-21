package DailyChallenge.Graph.WordLadder.Approach_1;
// https://leetcode.com/problems/word-ladder/
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Data> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        queue.offer(new Data(beginWord, 1));

        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int step = queue.peek().step;
            if (word.equals(endWord)){
                return step;
            }
            queue.remove();

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z' ; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);

                    if (set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.offer(new Data(replacedWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Data{
    String word;
    int step;
    Data(String word, int step){
        this.word = word;
        this.step = step;
    }
}
