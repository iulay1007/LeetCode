/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution24 {
    ListNode prv;
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        prv=head;
        head=head.next;
        change(prv);
        return head;
    }

    private void change(ListNode node) {
        if(node==null||node.next==null)
            return;
        ListNode temp=node.next;
        temp.next=node;
        change(temp);

    }
}