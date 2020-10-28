import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
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
//递归
class Solution94 {
    List<Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        pre(root);
        return list;

    }

    private void pre(TreeNode node) {
        if(node == null)
            return;

        pre(node.left);
        list.add(node.val);
        pre(node.right);

    }
}

/*
 迭代！
 public List<Integer> inorderTraversal(TreeNode root) {
        //list存储结果的
        List<Integer> list = new ArrayList<>();
        //栈存储结点的
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            //找当前节点的左子节点，一直找下去，直到为空为止
            while (root != null) {
            
                stack.push(root);
                root = root.left;
            }
            //出栈，这时候root就是最左子节点
            root = stack.pop();
            //然后把最左子节点加入到集合中
            list.add(root.val);
            //最后再访问他的右子节点
            root = root.right;
        }
        return list;
    }
*/