package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。

 */
public class OfferII044 {
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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0 ;i<size;i++){
                TreeNode node = deque.pop();
                max = Math.max(max,node.val);
                if(node.left!=null){
                    deque.add(node.left);
                }
                if(node.right!=null){
                    deque.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }

}
