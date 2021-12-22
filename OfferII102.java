package 剑指offer;
/**剑指 Offer II 102. 加减的目标值
 给定一个正整数数组 nums 和一个整数 target 。

 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。



 示例 1：

 输入：nums = [1,1,1,1,1], target = 3
 输出：5
 解释：一共有 5 种方法让最终目标和为 3 。
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3
 示例 2：

 输入：nums = [1], target = 1
 输出：1
 */
public class OfferII102 {
    //用回溯简单
    //https://leetcode-cn.com/problems/YaVDxD/solution/jia-jian-de-mu-biao-zhi-by-leetcode-solu-be5t/
    public int findTargetSumWays(int[] nums, int target) {
        //求neg的办法可以去看题解
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1;i<=n;i++){
            int num = nums[i-1];
            for (int j =0;j<=neg;j++){
                if (j>=num){
                    dp[i][j] += dp[i-1][j] +dp[i-1][j-num];
                }else {
                    dp[i][j] += dp[i-1][j];
                }

            }
        }
        return dp[n][neg];
    }
}