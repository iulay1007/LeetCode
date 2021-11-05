/**1218. 最长定差子序列
 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。

 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。



 示例 1：

 输入：arr = [1,2,3,4], difference = 1
 输出：4
 解释：最长的等差子序列是 [1,2,3,4]。
 示例 2：

 输入：arr = [1,3,5,7], difference = 1
 输出：1
 解释：最长的等差子序列是任意单个元素。
 示例 3：

 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 输出：4
 解释：最长的等差子序列是 [7,5,3,1]。*/
//可以用Hashmap优化
public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int[] dp = new int[40001];
        for (int num : arr) {
            dp[num + 20000] = dp[num + 20000 - difference] + 1;
            ans = Math.max(ans, dp[num + 20000]);
        }
        return ans;
    }

}