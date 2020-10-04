
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 检查平衡性 {
    int left,right;
    int left,right;
    public boolean isBalanced(TreeNode root) {

   if(root==null)
    return true;

        left=dfs(root.left,0);
        right=dfs(root.right,0);

        if(Math.abs(left-right)>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);

    }

    private int dfs(TreeNode root,int dp) {
        if (root == null)
            return dp;

        int Left = dfs(root.left, dp + 1);
        int Right = dfs(root.right, dp + 1);

        return Math.max(Left, Right);




    }}

