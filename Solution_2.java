/*
2. 两数相加
给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储位数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

Definition for singly-linked list.
        * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sumListNode=new ListNode(0);

        if(l1==null&&l2==null)
            return null;

        if (l1==null)
            l1=new ListNode(0);
        else if(l2==null)
            l2=new ListNode(0);


        if((l1.val+ l2.val)>9) {

            sumListNode.val = l1.val + l2.val - 10;
           if(l1.next==null)
               l1.next=new ListNode(1);
           else l1.next.val++;
        }
        else sumListNode.val = l1.val + l2.val;


        sumListNode.next=addTwoNumbers(l1.next,l2.next);
        return sumListNode;

    }


}
