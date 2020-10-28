/**
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution101 {

        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;

            return f(root.left,root.right);


        }

        private boolean f(TreeNode lnode,TreeNode rnode) {
            if(lnode==null&&rnode==null)
                return true;
            if(lnode==null||rnode==null)
                return false;
            return lnode.val== rnode.val&&f(lnode.left,rnode.right)&&f(lnode.right,rnode.left);
        }
    }