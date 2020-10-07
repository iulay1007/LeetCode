import java.util.ArrayList;
import java.util.List;

/**783. 二叉搜索树节点最小距离
 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
((任意！！！！！！！！！！


 示例：

 输入: root = [4,2,6,1,3,null,null]
 输出: 1
 解释:
 注意，root是树节点对象(TreeNode object)，而不是数组。

 给定的树 [4,2,6,1,3,null,null] 可表示为下图:

 4
 /   \
 2      6
 / \    
 1   3  

 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution783 {
    List<Integer> list= new ArrayList();;

    public int minDiffInBST(TreeNode root) {


        dfs(root);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; ++i)
            result = Math.min(result, list.get(i+1) - list.get(i));

        return result;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}

