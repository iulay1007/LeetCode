import java.util.ArrayList;
import java.util.List;

public class Solution437 {
    int result=0;
    //超时
    public int pathSum(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<>();
        findPath(root,sum,list);
        return result;
    }
    void findPath(TreeNode node, int sum, List<Integer> path){
        if(node==null)
            return;
        if(path.size()==0) {
            if(node.val==sum)
                result++;
            path.add(node.val);
            System.out.println("0 "+node.val);
            findPath(node.left,sum,new ArrayList<>(path));
            findPath(node.right,sum,new ArrayList<>(path));

            return;
        }
        for(int i=0;i<path.size();i++){
            if( path.get(i)+ node.val==sum)
                result++;
            path.set(i,path.get(i)+ node.val);
            System.out.println("num"+path.get(i));

        }
        if(node.val==sum)
            result++;
        path.add(node.val);
        findPath(node.left,sum,new ArrayList<>(path));
        findPath(node.right,sum,new ArrayList<>(path));

    }
}

/*
较简单，但是暴力
* public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    int helper(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
    }




}*/

/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }*/


     /* 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param prefixSumCount 前缀和Map
     * @param target 目标值
     * @param currSum 当前路径和
     * @return 满足题意的解
     */
    /*
    用map,key是和的值，value是出现次数
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
       // 因为到了最后，回到本层，表示当前层递归完成，要返回上一层，所以要清空这一层的状态，因为map传递的是一个对象，状态被修改了，为了不影响后面的递归遍历，就要清除本层做的操作
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}


*/