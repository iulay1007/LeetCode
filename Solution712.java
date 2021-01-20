import java.util.Arrays;

/*
712. 两个字符串的最小ASCII删除和
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。

示例 1:

输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
示例 2:

输入: s1 = "delete", s2 = "leet"
输出: 403
解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大
*/
public class Solution712 {
    int memo[][];
    public int minimumDeleteSum(String s1, String s2) {
        int a=s1.length();
        int b=s2.length();
        memo=new int[a][b];
        return dp(s1,0,s2,0);

    }
    int dp(String s1,int a,String s2,int b){
        int result=0;
        if(s1.length()==a){
            for(int j=b;j<s2.length();j++)
                result += s2.charAt(j);
            return result;
        }
        else if(s2.length()==b){
            for(int j=a;j<s1.length();j++)
                result+=s1.charAt(j);
            return result;
        }
        if (memo[a][b]!=0)
            return memo[a][b];
        if(s1.charAt(a)==s2.charAt(b))
            memo[a][b]=dp(s1,a+1,s2,b+1);
        else memo[a][b]= Math.min(s1.charAt(a)+dp(s1,a+1,s2,b),s2.charAt(b)+dp(s1,a,s2,b+1));

        return memo[a][b];
    }
}
