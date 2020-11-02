import java.util.*;

/**
 * 
 * 57. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution257 {
    Stack<Object> stack=new Stack<>();

    List<String> list=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root==null)
            return list;

        stack.push(root);
        stack.push(root.val+"");
        while (!stack.isEmpty()){
            String string=(String) stack.pop();
            TreeNode node=(TreeNode) stack.pop();

            if (node.left==null&&node.right==null)
            {
                list.add(string);

            }
            if(node.right!=null)
            { stack.push(node.right);
                stack.push(string+"->"+node.right.val);

            }
            if(node.left!=null)
            {
                stack.push(node.left);
                stack.push(string+"->"+node.left.val);
            }


        }




        return  list;

    }
}