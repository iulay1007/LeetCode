import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class 从上到下打印二叉树II {

    Queue<TreeNode> queue=new LinkedList<>();
    List<List<Integer>> list=new ArrayList<>();


    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null)
            return list;

        queue.add(root);

        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> templist=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                templist.add(node.val);

                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            list.add(templist);


        }
        //这个toArray就很有灵性
        return  list;
    }}