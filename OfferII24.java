package 剑指offer;

/**剑指 Offer II 024. 反转链表
 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。*/
public class OfferII24 {

    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre =null;
        ListNode slow = head;
        while(slow!=null){
            ListNode t = slow.next;
            slow.next = pre;
            pre = slow;
            slow = t;
        }
        return pre;

    }

 /**   class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }*/


}
