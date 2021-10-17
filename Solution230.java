import java.util.ArrayList;
import java.util.List;
/*
* 230. 二叉搜索树中第K小的元素
* 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Solution230 {
    /*
    * 执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.1 MB
, 在所有 Java 提交中击败了
76.58%
的用户*/
    int k = 0;
    int cur = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        solution(root);
        return result;
    }

    private void solution(TreeNode root) {
        if(root == null)
            return;
        if(cur == k)
            result = root.val;
        solution(root.left);
        cur++;
        solution(root.right);
    }
}

/*
最笨最慢
*   List<Integer> list = new ArrayList<>();
    int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        solution(root);
        return list.get(k-1);
    }

    private void solution(TreeNode root) {
        if(root == null)
            return;
        if(list.size() == k)
            return;
        solution(root.left);
        list.add(root.val);
        solution(root.right);
    }*/