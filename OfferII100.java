package 剑指offer;

import java.util.List;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 给定一个三角形 triangle ，找出自顶向下的最小路径和。

 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



 示例 1：

 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 输出：11
 解释：如下面简图所示：
 2
 3 4
 6 5 7
 4 1 8 3
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 示例 2：

 输入：triangle = [[-10]]
 输出：-10
 */
public class OfferII100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int dp[][] = new int[h+1][h+1];
        for (int i =h-1 ;i>=0;i--){
            for (int j = 0;j<=i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }

        }
        return dp[0][0];
    }

}
