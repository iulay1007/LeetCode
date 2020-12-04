import java.lang.Math;
import java.util.Arrays;
/*279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.*/
public class Solution279 {
    public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;


    int square = (int) Math.sqrt(n) + 1;
    int nums[] = new int[square];
    for (int i = 1; i < square; ++i) {
        nums[i] = i * i;
    }

    for (int i = 1; i <= n; ++i) {
        for (int s = 1; s < square; ++s) {
            if (i < nums[s])
                break;
            dp[i] = Math.min(dp[i], dp[i - nums[s]] + 1);
        }
    }
    return dp[n];
}
}

//总有一些笨笨的解法解不出来55
    /*
    public int numSquares(int n) {

            int dp[]=new int[n+1];
            dp[0]=0;
            dp[1]=1;
            dp[2]=2;
            dp[3]=3;
            dp[4]=1;
            for(int i=5;i<=n;i++)
            {
                int temp=-1;
                if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i)
                    dp[i]=1;
                else {

                    while(temp!=0)
                    {
                        temp=find(i);
                        dp[i]=Math.min(dp[temp]+dp[i-temp],dp[i]);
                        temp=i;
                    }
                }

            }
            return dp[n];
        }
        int find(int num){
            for(int i=num;i>=0;i--)
                if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i)
                    return i;
            return num;
        }
    }*/