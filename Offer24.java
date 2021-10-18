package 剑指offer;
/*
* 剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
* */
public class Offer24 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    ListNode result;
    public ListNode reverseList(ListNode head) {
        solution(head,null);
        return result;
    }

    private void solution(ListNode head,ListNode pre) {
        if (head == null)
            return;
        ListNode temp = head.next;
        head.next = pre;
        solution(temp,head);
        if( temp==null )
        {
            result = head;
        }
    }

}
/*
* public ListNode reverseList(ListNode head) {
        
        if(head==null||head.next==null)
            return head;
      ListNode  listNode=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;

    }*/
