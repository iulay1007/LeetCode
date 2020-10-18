/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *

 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 *  
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 */

public class 删除中间节点 {
    public void deleteNode(ListNode node) {

        if(node.next==null)

            return;
       node.val= node.next.val;
       if(node.next.next==null) {
           node.next = null;
           return;
       }
       node=node.next;
       deleteNode(node);






    }
}
//大佬的思路（两行qwq
我还是想的太复杂了qwq
/*
已知一个结点，以及该节点后的所有结点
求该结点的前一个结点,无法求
但还知道这个结点的地址，
可以更换该这个结点的数据为下一个结点，然后删除下一个结点

class Solution {
    public void deleteNode(ListNode node) {
        
        //将这个结点的数据替换为下一个结点
        node.val = node.next.val;
        //删除下一个结点
        node.next = node.next.next;
        
    }
}
*/