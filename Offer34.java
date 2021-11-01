package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer 34. 二叉树中和为某一值的路径
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。



示例 1：



输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：



输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]**/
public class Offer34 {

      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    List<List<Integer>> lists = new ArrayList<>();
      int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        solution(root,0,new ArrayList());
        return lists;
    }

    void solution(TreeNode node,int num,List<Integer> path){
        if(node == null){
            return;
        }
        if (node.left==null&&node.right==null){
            if(num+ node.val == target)
            {
                path.add(node.val);
                lists.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }}

        path.add(node.val);
        solution(node.left,num+ node.val,path);
        solution(node.right,num+ node.val,path);
        path.remove(path.size()-1);

    }

}


