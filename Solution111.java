
import java.util.LinkedList;

import java.util.Queue;
/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        int depth=1;
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++)
            {

                TreeNode treeNode=queue.remove();
                if(treeNode.left==null&&treeNode.right==null)
                    return depth;
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                if(treeNode.right!=null)
                    queue.add(treeNode.right);
            }
            depth++;

        }
        return depth;
    }
}
