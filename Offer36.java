package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

 为了让您更好地理解问题，以下面的二叉搜索树为例：

 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

 */
public class Offer36 {

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

    class Solution {
        List<Node> nodes = new ArrayList<>();
        public Node treeToDoublyList(Node root) {
            if(root == null)
                return null;
         solution(root);
         for(int i =0;i<nodes.size();i++){
             if(i+1<nodes.size())
             nodes.get(i).right=nodes.get(i+1);
             else nodes.get(i).right = nodes.get(0);
             if(i!=0)
                 nodes.get(i).left=nodes.get(i-1);
             else nodes.get(0).left = nodes.get(nodes.size()-1);

         }

        return nodes.get(0);
        }
        private Node solution(Node node) {
            if(node == null)
                return null;

            solution(node.left);
            nodes.add(node);
            solution(node.right);
            return node;
        }
    }
    /**class Solution {
     Node pre, head;
     public Node treeToDoublyList(Node root) {
     if(root == null) return null;
     dfs(root);
     head.left = pre;
     pre.right = head;
     return head;
     }
     void dfs(Node cur) {
     if(cur == null) return;
     dfs(cur.left);
     if(pre != null) pre.right = cur;
     else head = cur;
     cur.left = pre;
     pre = cur;
     dfs(cur.right);
     }
     }
*/


}
