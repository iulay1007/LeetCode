package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 剑指 Offer 35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。



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

* */
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
public class Offer35 {

    class Solution {
        List<Node> list = new ArrayList<>();
        Map<Node,Integer> map = new HashMap<>();
        public Node copyRandomList(Node head) {
            Node temp = head;
            int i = 0;
            while (head!=null){
                Node node = new Node(head.val);
                list.add(node);
                map.put(head,i);
                head = head.next;
                i++;
            }
            i = 0;
            while (temp!=null){
                if(i<list.size())
                list.get(i).next = list.get(i+1);
                if(map.get(temp.random)!=null)
                list.get(i).random = list.get(map.get(temp.random));
                else list.get(i).random = null;
                temp =temp.next;
                i++;
            }
            if(list.size()==0)
                return null;
            return list.get(0);
        }
    }
}
/*
* class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
* */
