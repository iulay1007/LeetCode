import java.util.ArrayList;
import java.util.List;
/*199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 

示例 1:



输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:

输入: [1,null,3]
输出: [1,3]
示例 3:

输入: []
输出: []*/
public class Solution199 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }

    void dfs(TreeNode node,int height){
        if (node == null)
            return;
       if(result.size()<=height)
       {
           result.add(node.val);
       }
       else {
           result.set(height, node.val);

       }
       dfs(node.left,height+1);
       dfs(node.right,height+1);

    }
}
/*
* 换一下遍历顺序就会简单很多qwq官方题解yyds
* class Solution {
      List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }

    void dfs(TreeNode node,int height){
        if (node == null)
            return;
       if(result.size()==height)
       {
           result.add(node.val);
       }


       dfs(node.right,height+1);
        dfs(node.left,height+1);

    }
}*/