
/*474. 一和零
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 

示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];//已经被赋初值0
        for (int i = 0; i < strs.length; i++) {
            int[] count = count(strs[i]);
            for (int j = m; j >= 0; j--) {
                for(int k = n; k >= 0; k--) {
                    if (count[0] > j || count[1] > k) {
                        dp[j][k] = dp[j][k];
                    } else {
                        dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

    public int[] count(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c -'0']++;
        }
        return count;
    }
}
