
/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution203  {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        while (head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null||head.next==null)
            return head;
        ListNode node=new ListNode(0);
        node.next=head;
        while (node!=null){
            if(node.next!=null&&node.next.val==val)
                node.next=node.next.next;
            else  node=node.next;
        }

        return head;

    }
}

/*
dalao递归解法！！！
class Solution {
    public ListNode removeElements(ListNode head, int val) {
       if(head==null)
           return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
}

/////////
添加一个虚拟头结点
（常用于不知道头结点是否会被改变的时候！！

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
    }
}

*/