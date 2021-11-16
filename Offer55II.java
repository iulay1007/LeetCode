package 剑指offer;
/**剑指 Offer 55 - II. 平衡二叉树
 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。*/
public class Offer55II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&(Math.abs(helper(root.left)-helper(root.right))<2);
    }

    int helper(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(helper(root.left),helper(root.right))+1;
    }
}
