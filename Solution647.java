/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
*/
//注意遍历的方向
//https://leetcode-cn.com/problems/palindromic-substrings/solution/shou-hua-tu-jie-dong-tai-gui-hua-si-lu-by-hyj8/
public class Solution647 {
    public int countSubstrings(String s) {
        int [][]dp =new int[s.length()][s.length()];
        int count=s.length();

        for(int i=0,j=1;i<s.length()&&j<s.length();i++,j++)
        {
            dp[i][i]=1;
            if(s.charAt(i)==s.charAt(j))
            {
                dp[i][j]=1;
            }


        }
        dp[s.length()-1][s.length()-1]=1;
        for(int j=0;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1||j-i==2)
                    {
                        System.out.println("i"+i+"j"+j);
                        dp[i][j]=1;
                        count++;
                    }
                    else {

                        dp[i][j]=dp[i+1][j-1];
                        if(dp[i][j]==1){
                            count++;
                            System.out.println("i"+i+"j"+j);
                        }
                    }

                }


            }
        }
        return count;
    }
}
/*另一种解法
* 中心拓展，说白了，就是挨个遍历，只不过，中心可能是1个字符也可能是2个字符而已，

不可能出现3个字符作为中心的情况，因为3个字符作为中心的话，他就是回文了，等于1个字符作为中心的情况

我觉得下面的代码更好理解一点

class Solution {
  public int countSubstrings(String s) {
        int num = 0;
        int n = s.length(); 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=1;j++)
            {
                int l = i;
                int r = i+j;
                while(l>=0 && r<n && s.charAt(l--)==s.charAt(r++))num++;
            }
        }
        return num;
    }
};*/