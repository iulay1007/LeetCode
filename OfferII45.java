package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

 假设二叉树中至少有一个节点。

 */
public class OfferII45 {
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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int res = root.val;
        while (!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0 ;i<size;i++){
                TreeNode node = deque.pop();
                if(i == 0 )
                    res = node.val;
                if(node.left!=null)
                    deque.add(node.left);
                if(node.right!=null)
                    deque.add(node.right);
            }
        }
        return res;
    }
}
