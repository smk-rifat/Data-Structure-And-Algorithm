package DailyChallenge.Tries.ImplementTrie;
// https://leetcode.com/problems/implement-trie-prefix-tree/description/
class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (cur.child[idx] == null) cur.child[idx] = new Node();
            cur = cur.child[idx];
        }
        cur.eow = true;
    }
    public boolean search(String word) {
       Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return cur.eow;
    }
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';
            if (cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return true;
    }
    private static class Node{
        Node[] child;
        boolean eow;
        public Node(){
            child = new Node[26];
            eow = false;
        }
    }
}