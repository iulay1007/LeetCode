/*
* 583. 两个字符串的删除操作
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。



示例：

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
* */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int a=word1.length();
        int b=word2.length();
        if(a==0)
            return b;
        else if(b==0)
            return a;
        int l=longestCommonSubsequence(word1,word2);
        return a+b-2*l;


}
    public int longestCommonSubsequence(String text1, String text2) {
        int a=text1.length();
        int b=text2.length();
        int dp[][]=new int[a+1][b+1];
        dp[0][0]=0;
        for(int i=1;i<=a;i++)
            for(int j=1;j<=b;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);

            }
        return dp[a][b];
    }
}