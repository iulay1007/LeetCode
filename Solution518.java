/*518. 零钱兑换 II
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。



示例 1:

输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2:

输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
示例 3:

输入: amount = 10, coins = [10]
输出: 1
*/

public class Solution518 {
    public int change(int amount, int[] coins) {
        int length=coins.length;
    int dp[][]=new int[length+1][amount+1];
        for(int i=0;i<=length;i++)
        {
            dp[i][0]=1;
        }

        for(int i=1;i<=length;i++)
            for(int j=1;j<=amount;j++)
            {
                if(j-coins[i-1]>0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                else dp[i][j]=dp[i-1][j];

            }

        return dp[length][amount];
    }
}