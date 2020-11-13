import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    /**
     * Definition for a binary tree node.
     * struct TreeNode {
     *     int val;
     *     struct TreeNode *left;
     *     struct TreeNode *right;
     * };
     * 530. 二叉搜索树的最小绝对差
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     *
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     */


    class Solution530 {
        List<Integer> list=new ArrayList<>();
        public int getMinimumDifference(TreeNode root) {
            int result=0;
            int temp=0;
            dfs(root);
          //  Object[] num=list.toArray();
            int num[]=new int[list.size()];
            for(int i=0;i<list.size();i++)
            {
               num[i]=list.get(i);
            }
            Arrays.sort(num);
            if(list.size()==0){
                return 0;
            }
            if(list.size()==1)
                return list.get(0);
            int j=1;
          result=Math.abs(num[0]-num[1]);
            for(int i=0;i<list.size()-1;i++)
            {
               temp=Math.abs((num[i]-num[j]));
               if(temp<result)
                   result=temp;
               j++;
            }

            return result;

        }

        private void dfs(TreeNode node) {
            if (node==null)
                return;
            list.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    /*
    啊我又忘了！！！！！！！！！！！！
    本题要求二叉搜索树任意两节点差的绝对值的最小值，而我们知道二叉搜索树有个性质为二叉搜索树中序遍历得到的值序列是递增有序的
    class Solution {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}

二叉树的中序遍历如下
非递归！
public static void inOrderTraversal(TreeNode tree) {
    Stack<TreeNode> stack = new Stack<>();
    while (tree != null || !stack.isEmpty()) {
        while (tree != null) {
            stack.push(tree);
            tree = tree.left;
        }
        if (!stack.isEmpty()) {
            tree = stack.pop();
            System.out.println(tree.val);
            tree = tree.right;
        }
    }
}
这里可以参照二叉树的非递归写法来改造一下


    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, prev = null;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                //在这里进行改造
                if (prev != null)
                    min = Math.min(min, cur.val - prev.val);
                prev = cur;
                
                cur = cur.right;
            }
        }
        return min;
    }


*/