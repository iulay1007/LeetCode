package 剑指offer;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。

 节点 node 的子树为 node 本身，以及所有 node 的后代。

 */
public class OfferII47 {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode pruneTree(TreeNode root) {
        helper2(root);
        if(root.left == null&&root.right == null&&root.val == 0)
            return null;
        return root;
    }

    void helper2(TreeNode node){
         if(node == null)
             return;
        if(helper1(node.left)){
            node.left = null;
        }
        if(helper1(node.right)){
            node.right = null;
        }
        if(node.left == null&&node.right==null&&node.val == 0)
        {
            System.out.println("qwq");
            node = null;

            return;
        }
         helper2(node.left);
         helper2(node.right);
    }

    boolean helper1(TreeNode node){
         if(node ==null)
             return true;

        return node.val == 0 && helper1(node.left) && helper1(node.right);
    }
}
