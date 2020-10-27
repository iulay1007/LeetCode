
/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
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
public class Solution110 {


        public boolean isBalanced(TreeNode root) {
            if(root==null)
                return true;

            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                    isBalanced(root.left) && isBalanced(root.right);//递归调用，
        }

        private int getHeight(TreeNode root) {
            //递归出口
            if (root == null) {
                return 0;
            } else {
                int height= Math.max(getHeight(root.left), getHeight(root.right));
                height++;
                return height;
            }
        }



    }
    /*
    参照求深度的题解！！
    class Solution104 {
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        } else {

            return Math.max( maxDepth(root.left),  maxDepth(root.right)) + 1;
        }
    }
}


*/