
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        addAll(root, root.val,sum);

    }

    private int addAll(TreeNode node,int total,int sum) {
        if (node==null)
            return total;

        addAll(node.left,total,sum);
        total=total+ node.val;
        addAll(node.right,total,sum);


        return total;
    }
}