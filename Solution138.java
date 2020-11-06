
/*

138. 复制带随机指针的链表
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。


示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。


提示：
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


import java.util.HashMap;

//错误的qwq题目奇奇怪怪看不懂且有误导性啊我觉得
//如果原来的random是2，则让复制了的random指向新表的第random个！
/*
class 复杂链表的复制 {
    Node prv=new Node(0);
    Node newhead=prv;

    public Node copyRandomList(Node head) {
        copy(head);
        copyrandom(head);
        return newhead;

    }



    private void copy(Node node) {
        if(node==null||node.next==null||prv==null)
            return;
        Node temp=node.next;
        prv.val= node.val;
        prv.next=temp;
        prv.next=new Node(0);
        prv=prv.next;
        copy(node.next);
    }
    private void copyrandom(Node node) {
        if(node==null||node.next==null)
            return;
        // Node temp=node.next;
        prv.random= node.random;
        //prv.random=node.random;
        //prv.next=temp;
        prv=prv.next;
        copy(node.next);

    }
}*/
class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
        Node node=new  Node(p.val);
        map.put(p, node);
        p = p.next;
        }
        p = head;
        while (p != null) {
        map.get(p).next = map.get(p.next);
        map.get(p).random = map.get(p.random);//p的random对应的元素的value即为所求
        p = p.next;
        }
        return map.get(head);
        }
}

