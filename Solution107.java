import java.util.*;
/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();

        if(root==null)
            return result;
        Stack<List<Integer>> stack=new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> templist=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode treeNode=queue.remove();
                templist.add(treeNode.val);
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                if(treeNode.right!=null)
                    queue.add(treeNode.right);
            }
            stack.add(templist);

        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }
}