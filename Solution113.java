import java.util.ArrayList;
import java.util.List;
/*113. 路径总和 II
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
输出：[]
 */
public class Solution113 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list=new ArrayList<>();

    backtrack(root,targetSum,0,list);
    return result;

    }
        void backtrack(TreeNode node,int target,int sum,List<Integer> path){

        if(node==null)
            return;
        path.add(node.val);
        sum+= node.val;
        if(node.left==null&&node.right==null)
        {
            if(sum==target)
            result.add(path);
            else return;
        }

        backtrack(node.left,target,sum,new ArrayList<>(path));
        backtrack(node.right,target,sum,new ArrayList<>(path));



        }

}
