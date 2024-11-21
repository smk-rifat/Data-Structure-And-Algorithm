package DailyChallenge.Tries.DesignAddandSearchWordsDataStructure;
// https://leetcode.com/problems/design-add-and-search-words-data-structure/
class Node {
    Node[] child;
    boolean eow;
    public Node(){
        child = new Node[26];
        eow = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if (cur.child[idx] == null) cur.child[idx] = new Node();
            cur = cur.child[idx];
        }
        cur.eow = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        return search(word, cur);
    }
    private boolean search(String word, Node cur){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c -'a';
            if (c != '.' && cur.child[idx] == null) return false;
            if (c == '.'){
                for (Node child : cur.child){
                    if (child != null && search(word.substring(i+1), child)) return true;
                }
                return false;
            }
            cur = cur.child[idx];
        }
        return cur.eow;
    }
}