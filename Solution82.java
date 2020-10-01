/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 *
 * 示例
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution82 {
  ListNode node;

    public ListNode deleteDuplicates(ListNode head) {


        if(head==null||head.next==null) return head;
        if(head.val==head.next.val){
            head=head.next;
           while (head.next!=null&&head.val == head.next.val)
           {head=head.next;

           }
           return deleteDuplicates(head.next);



        }else if (head.val!=head.next.val){


           head.next=deleteDuplicates(head.next);
            return head;
        }
        return head;
    }
}