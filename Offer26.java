package 剑指offer;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Offer26 {
    TreeNode temp;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return false;
        temp = B;
        return solution(A, B);
    }

    private boolean solution(TreeNode a, TreeNode b) {
        if (b == null && a == null)
            return true;
        if (a == null)
            return false;
        if (b == null)
            return true;
        if (a.val == b.val) {
            if (solution(a.left, b.left) && solution(a.right, b.right))
                return true;
        }

        return solution(a.left, temp) || solution(a.right, temp);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}