package 剑指offer.ByteDance;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 */
public class Solution4 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children.isEmpty())
            return 1;
        int res = 0;
        for (int i = 0; i < root.children.size(); i++) {
            res = Math.max(res, maxDepth(root.children.get(i)));
        }
        return res + 1;
    }
}
