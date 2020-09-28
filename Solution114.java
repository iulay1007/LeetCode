import java.util.LinkedList;
import java.util.Stack;

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
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 
 */

public class Solution114 {






        TreeNode prev,curr;
        int length;
        public void flatten(TreeNode root) {

            Stack<TreeNode> stack=new Stack<>();
            LinkedList<TreeNode> list=new LinkedList<>();
            while (!stack.isEmpty()||root!=null) {
                while(root!=null) {

                    stack.push(root);
                    list.add(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }




            length=list.size();
            for(int i=1;i<length;i++){
                prev=list.get(i-1);
                curr=list.get(i);
                prev.left=null;
                prev.right=curr;

            }

        }
    }
