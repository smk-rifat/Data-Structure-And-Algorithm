package DailyChallenge.Tries.WordSearch_II.Approach_1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    HashMap<Character, Node> child;
    boolean isWord;
    Node(){
        child = new HashMap<>();
    }
}
class Trie{
    Node root = new Node();
    public void addWord(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.child.containsKey(ch)){
                current.child.put(ch, new Node());
            }
            current = current.child.get(ch);
        }
        current.isWord = true;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        boolean[][] visited = new boolean[row][col];
        for (String word: words){
            trie.addWord(word);
        }
        StringBuilder word = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(r,c,trie.root,ans,board, word, visited);
            }
        }
        return ans;
    }
    public void dfs(int r, int c, Node root, List<String> ans, char[][] board, StringBuilder word, boolean[][] visited){
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) return;

        char ch = board[r][c];
        if (!root.child.containsKey(ch)) return;
        visited[r][c] = true;
        root = root.child.get(ch);
        word.append(ch);

        if (root.isWord){
            ans.add(word.toString());
            root.isWord = false;
        }

        dfs(r+1,c,root, ans, board, word, visited);
        dfs(r-1,c,root, ans, board, word, visited);
        dfs(r,c+1,root, ans, board, word, visited);
        dfs(r,c-1,root, ans, board, word, visited);

        visited[r][c] = false;
        word.deleteCharAt(word.length()-1);
    }

}
