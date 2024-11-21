package DailyChallenge.LinkedList.LRU_cache.Approach1;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache 
class Node {
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
         this.capacity = capacity;
         cache = new HashMap<>();
         this.left = new Node(0,0);
         this.right = new Node(0,0);
         this.left.next = this.right;
         this.right.prev = this.left;

    }

    public int get(int key) {
        if (this.cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        } else return -1;
    }

    public void put(int key, int value) {
          if (cache.containsKey(key)){
              remove(cache.get(key));
          }
          cache.put(key, new Node(key, value));
          insert(cache.get(key));
          if (cache.size() > capacity){
              Node lru = this.left.next;
              remove(lru);
              cache.remove(lru.key);
          }
    }
    // remove from the left side from the list, cause that's the least recently used
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    // insert at just right before right pointer, that's the most recent used
    public void insert(Node node){
        Node prev = this.right.prev;
        Node next = this.right;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

}
