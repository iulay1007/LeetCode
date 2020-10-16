import java.util.Stack;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {


        if(head==null||head.next==null)
            return true;
        ListNode prev=head;
        ListNode prev1=head;

        Stack<ListNode> stack=new Stack();
        while (prev!=null)
        {
            stack.push(prev);
            prev=prev.next;

        }

        while (prev1.next!=null&&prev1.val==stack.pop().val){
            prev1=prev1.next;

        }
        if(prev1.next==null)
            return true;

        return false;


    }
}