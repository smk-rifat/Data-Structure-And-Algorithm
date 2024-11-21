package DailyChallenge.LinkedList.Merge_K_SortedList.Approach2;
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
// just applying merge sort algorithm
 class Solution {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
        int left = 0;
        int right = lists.length-1;
        ListNode head = sort(lists, left, right);
        return head;
    }
    static ListNode sort(ListNode[] lists, int left, int right){
        if (left == right) {
            return lists[right]; // or return lists[left]; 
        }
        int mid = (left+right)/2;
        ListNode l1 = sort(lists, left, mid);
        ListNode l2 = sort(lists, mid+1, right);
        return mergeIterative(l1, l2);
    }
    static ListNode mergeRecursive(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
    }
    static ListNode mergeIterative(ListNode l1, ListNode l2){
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            } else{
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            }
        }
        if (node1 != null) {
            temp.next = node1;
        } else {
            temp.next = node2;
        }
        return dummy.next;
    }
}
// time complexity O(n log k)
/*
 * The space complexity of the sort method remains O(log n) due to the recursion stack. 
 * Each recursive call consumes a certain amount of stack space, and the maximum depth of recursion is log N.
 */
