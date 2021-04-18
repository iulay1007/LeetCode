import java.util.ArrayList;
import java.util.List;
/*144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。*/
public class Solution144 {
    public List<Integer> list =new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
}

    private void dfs(TreeNode node) {
        if(node==null)
            return;
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}