import java.util.LinkedList;

/**
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

public class Solution114 {

    public void flatten(TreeNode root) {

        LinkedList<TreeNode> stack=new LinkedList<>();
        LinkedList<TreeNode> output=new LinkedList<>();
        while (root!=null){
            stack.add(root);

            while (!stack.isEmpty()){

                TreeNode node=stack.pollLast();
                output.add(node);
                if (node.right!=null)
                    stack.add(node.right);
                if (node.left!=null){


                    stack.add(node.left);
                }


            }
        }

        int size=output.size();
        for(int i=1;i<size;i++){
            TreeNode prev=output.get(i-1),curr=output.get(i);
            prev.left=null;
            prev.right=curr;



        }

}
}
