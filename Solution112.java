import java.util.ArrayList;
import java.util.List;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//暴力解法，把每一个节点的值改成到他的路径和
    //不止我一个人这样想hhhh
class Solution112 {
    List<Integer> list=new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        addAll(root);

        while (!list.contains(sum))
            return false;
        return true;

    }

    private void addAll(TreeNode node) {
        if (node==null)
            return;
        if (node.left==null&&node.right==null)
            list.add(node.val);
        if(node.left!=null)
        {  node.left.val+=node.val;
            addAll(node.left);}
        if(node.right!=null)
        { node.right.val+=node.val;
            addAll(node.right);}


    }
}
/*
//别人家的递归qwq！！
从根节点开始，每当遇到一个节点的时候，从目标值里扣除节点值，一直到叶子节点判断目标值是不是被扣完。

  public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            return sum-root.val==0;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
其实，做为树的递归题目是非常有套路可循的，因为树有两个分支，所以在递归里也有两个分支，一般是通过 递归 A（||，&&）递归 B 来实现分支的。只要明白了这一点，递归函数就不会很难设计

*/
