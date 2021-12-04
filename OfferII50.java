package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class OfferII50 {
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

 /*easy way
  int res =  0;
    public int pathSum(TreeNode root, int targetSum) {
           if(root == null)
               return 0;

           helper(root,targetSum,0);
           pathSum(root.left,targetSum);
           pathSum(root.right,targetSum);
            return res;
    }

    private void helper(TreeNode root, int targetSum ,int sum) {
        if(root == null)
            return;
        sum+=root.val;
        if(sum == targetSum)
            res++;
        helper(root.left,targetSum,sum);
        helper(root.right,targetSum,sum);

    }*/

    //如果不是树，很容易想到前缀和，但是其实树也可以用前缀和
    Map<Integer,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        map.put(0,1);
        return helper(root,targetSum,0);

    }

    int helper(TreeNode node ,int targetSum,int pre ){
        if(node == null)
            return 0;
        pre+=node.val;
        int res = map.getOrDefault(pre - targetSum,0);
        map.put(pre,map.getOrDefault(pre,0)+1);
        res+=helper(node.left,targetSum,pre);
        res+=helper(node.right, targetSum,pre);
        map.put(pre,map.get(pre)-1);
        return res;
    }
}
