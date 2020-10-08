
/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution92 {
    ListNode head1,cur,endNext,p;

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode prev=new ListNode(0);
        prev.next=head;





        for(int i = 0; i < m - 1; i++)
        {
            prev = prev.next;
        }
        p=prev;

        ListNode begin = prev.next;

        for(int j = 0; j <= n - m; j++)
        {
            prev=prev.next;
        }
        endNext = prev.next;

        cur=prev.next;


        head1= reverseList(head,prev);
        p.next=head1;
        begin.next = endNext;



        return head;

    }

    public ListNode reverseList(ListNode head,ListNode tail) {
        if(head == tail)
            return head;

        ListNode cur = reverseList(head.next, tail);
        head.next.next = head;
        return cur;

    }
}