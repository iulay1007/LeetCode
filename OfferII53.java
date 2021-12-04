package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。

 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。

 */
public class OfferII53 {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   //    easy way
    List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root);
        if(list.get(list.size()-1) == p)
            return null;
        return list.get(list.indexOf(p)+1);
    }

    void helper(TreeNode node){
         if(node == null)
             return;
         helper(node.left);
         list.add(node);
         helper(node.right);
    }

    /**
     * better ans
     *  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
     // 记录当前比 p 节点大的节点
     TreeNode ans = null;
     // 在二叉搜索树中进行搜索
     while(root != null){
     // 如果当前节点 > p，则更新当前比 p 节点大的节点 ans , 同时去左子树进行搜索
     if(root.val > p.val){
     ans = root;
     root = root.left;
     }else{// 如果当前节点 < p , 则到右子树进行搜索
     root = root.right;
     }
     }
     // 当搜寻结束后，ans 保存的就是最近的比 p 节点大的节点。
     return ans;
     }

     */

}
