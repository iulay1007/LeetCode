
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class 反转链表 {
        public ListNode reverseList(ListNode head) {
            ListNode listNode;
            if(head==null||head.next==null)
                return head;
            listNode=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return listNode;

        }
    }
