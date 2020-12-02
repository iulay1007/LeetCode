/* /**
 *先运用数学方法化简问题的规模
 * 排列组合：n位有效数字 = 每一位都从 0~9 中选择，且不能以 0 开头
 * 1位数字：0~9                      10
 * 2位数字：C10-2，且第一位不能是0      9 * 9
 * 3位数字：C10-3，且第一位不能是0      9 * 9 * 8
 * 4位数字：C10-4，且第一位不能是0      9 * 9 * 8 * 7
 * ... ...
 * 最后，总数 = 所有 小于 n 的位数个数相加
 */
//我真的没想到55
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 9;
    int min = Math.min(10, n);
    int ans = 10;
    for (int i = 1; i < min; i++) {
        dp[i + 1] = dp[i] * (10 - i);
        ans += dp[i + 1];
    }
    return ans;
}
}

/*：回溯
这个需要遍历都所有有效数字，复杂度高

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }

    private int dfs(int n, int idx, boolean[] used) {
        int count = 0;
        if (idx != n) {
            for (int i = 0; i < 10; i++) {
                // 剪枝：多位数时，第一个数字不能为0
                if (i == 0 && n > 1 && idx == 1) {
                    continue;
                }
                // 剪枝：不能使用用过的数字
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, idx + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;
    }
}
*/