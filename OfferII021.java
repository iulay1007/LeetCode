package 剑指offer;
/**剑指 Offer II 021. 删除链表的倒数第 n 个结点
 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



 示例 1：



 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]
 示例 2：

 输入：head = [1], n = 1
 输出：[]
 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]
 */
public class OfferII021 {
     class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         public ListNode removeNthFromEnd(ListNode head, int n) {
             ListNode slow = head;
             ListNode fast = head;
             int count =1 ;
             while (fast!=null&&count!=n+1){
                 fast=fast.next;
                 count++;
             }
             if(fast == null&&count==n+1) return head.next;
             while (fast.next!=null){
                 fast = fast.next;
                 slow = slow.next;
             }
             if(slow!=null&&slow.next!=null)
             {slow.next = slow.next.next;}
             else return null;
             return head;
         }
     }

}