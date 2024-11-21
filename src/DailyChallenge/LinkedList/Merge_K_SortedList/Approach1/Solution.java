package DailyChallenge.LinkedList.Merge_K_SortedList.Approach1;
import java.util.ArrayList;
import java.util.Comparator;
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists){
      ArrayList<Integer> store = new ArrayList<>();
      for(ListNode list : lists){
          ListNode node = list;
          while(node != null){
              store.add(node.val);
              node = node.next;
          }
      }
      Comparator<Integer> com = Integer::compare;
      store.sort(com);
      ListNode dummy = new ListNode();
      ListNode temp = dummy;

        for (Integer integer : store) {
            temp.next = new ListNode(integer);
            temp = temp.next;
        }
        return dummy.next;
    }
    // TC -> O(Nlog(N))
    // SC -> O(N)
}
