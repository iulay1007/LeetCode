package 剑指offer;

public class Offer68II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        if (root.left == p && root.right == q)
            return root;
        else if (root.right == p && root.left == q)
            return root;

        else if (root == p) {
            return p;
        } else if (root == q) {
            return q;
        }

        if (lowestCommonAncestor(root.left, p, q) != null)
            return lowestCommonAncestor(root.left, p, q);
        else if (lowestCommonAncestor(root.left, p, q) != null)
            return lowestCommonAncestor(root.left, p, q);

        return root;

    }
}