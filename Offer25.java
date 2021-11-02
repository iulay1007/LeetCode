package 剑指offer;
/**
 * 
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 class Solution21 {
 public ListNode mergeTwoLists(ListNode l1, ListNode l2)  {
 if(l1==null)
 return l2;
 else    if(l2==null)
 return l1;


 if(l1.val< l2.val) {
 l1.next=   mergeTwoLists(l1.next, l2);
 return l1;

 }
 else {
 l2.next=  mergeTwoLists(l1, l2.next);
 return l2;
 }

 }}
 */
public class Offer25 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; } }

    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            return  solution(l1,l2);
        }
        ListNode solution(ListNode l1,ListNode l2){
            ListNode node = null;
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;
            if(l1.val > l2.val)
            {
                node = l2;
                node.next = solution(l1,l2.next);

            }
            else {
                node = l1;
                node.next = solution(l1.next,l2);
            }
            return node;

        }
    }
}
