import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 */
/*执行用时：
2 ms
, 在所有 Java 提交中击败了
83.60%
的用户
内存消耗：
39 MB
, 在所有 Java 提交中击败了
91.90%
的用户*/

//改着改着就对了5555
//也可以改成传入父节点~    
class Solution1110 {
    List <TreeNode> list = new ArrayList<>();
    HashSet <Integer> set;
    public List <TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null)
            return list;
        set = new HashSet<>(to_delete.length);
        for (int delete : to_delete) set.add(delete);
        if(set.contains(root.val) == false)
            list.add(root);
        helper(root);
        return list;
    }
    boolean  helper(TreeNode node){
        if(node == null)
            return false;

        if( helper(node.left))
            node.left=null;

        if(helper(node.right))
            node.right=null;

        if(set.contains(node.val))
        {
            if(node.left!=null&&!set.contains(node.left.val))
                list.add(node.left);
            if(node.right!=null&&!set.contains(node.right.val))
                list.add(node.right);
            return true;
        }

        return false;
    }
}