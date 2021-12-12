package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;
/**剑指 Offer II 078. 合并排序链表
 给定一个链表数组，每个链表都已经按升序排列。

 请将所有链表合并到一个升序链表中，返回合并后的链表。



 示例 1：

 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 输出：[1,1,2,3,4,4,5,6]
 解释：链表数组如下：
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 将它们合并到一个有序链表中得到。
 1->1->2->3->4->4->5->6
 示例 2：

 输入：lists = []
 输出：[]
 示例 3：

 输入：lists = [[]]
 输出：[]*/
public class OfferII78 {
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node :lists){
            while (node!=null){
                ListNode temp =node.next;
                priorityQueue.add(node);
                node.next = null;
                node =temp;
            }
        }
        if(priorityQueue.size() == 0) return null;
        ListNode pre = priorityQueue.poll();
        ListNode head = pre;
        while (priorityQueue.size()>0){
            pre.next = priorityQueue.poll();
            pre = pre.next;

        }
        return head;
     }

}
