import java.util.*;


/**
 *
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class 特定深度节点链表 {
    Queue<TreeNode> queue=new LinkedList<>();

    ListNode head=new ListNode(0);
    ListNode prv=head;
    List<ListNode> list=new ArrayList<>();


    public ListNode[] listOfDepth(TreeNode tree) {

        if(tree==null)
            return null;

        queue.add(tree);

        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                ListNode temp=new ListNode(node.val);
                prv.next=temp;
                prv=prv.next;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            if(head.next!=null)
                list.add(head.next);

            head.next=null;
            prv=head;


        }
        //这个toArray就很有灵性
        return  list.toArray(new ListNode[list.size()]);
    }
}