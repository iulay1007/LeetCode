/*
*650. 只有两个键的键盘
最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
Paste (粘贴) : 你可以粘贴你上一次复制的字符。
给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。

示例 1:

输入: 3
输出: 3
解释:
最初, 我们只有一个字符 'A'。
第 1 步, 我们使用 Copy All 操作。
第 2 步, 我们使用 Paste 操作来获得 'AA'。
第 3 步, 我们使用 Paste 操作来获得 'AAA'。
*  */
//我不知道别人怎么写出来那么简单的，我写出来了就是有点笨笨的555
public class Solution650 {
    public int minSteps(int n) {
        if(n==1)
            return 0;
        else if(n==2)
            return 2;
        else if(n==3)
            return 3;
        int dp[]=new int[n+1];
        dp[1]=0;
        dp[2]=2;
        dp[3]=3;

        for(int i=4;i<=n;i++)
            if(find(i)==0)
                dp[i]=dp[i/2]+2;
            else if(find(i)==i)
                dp[i]=i;
            else {
                int temp=find(i);
                dp[i]=dp[temp]+1+(i-temp)/temp;
            }
        return dp[n];

    }
    int find(int num)
    {
        int temp=0;
        if(num%2==0)
            return 0;
        for(int i=3;i<num;i++)
            if(num%i==0)
                temp=i;
        if(temp==0)
            return num;
        return temp;
    }
}