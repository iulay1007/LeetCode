/*5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
//心累了，看题解也不懂555555
*/public class Solution_5 {
    public String longestPalindrome(String s) {
        if(s.length()<=1)
            return s;
        if(s.length()==2&&s.charAt(0)==s.charAt(1))
            return s;
        else if(s.length()==2&&s.charAt(0)!=s.charAt(1))
            return s.substring(0,1);

        int length=s.length();
        String result="";
        int max=1;
        int begin=0;
        char ch[]=new char[length+1];
        ch=s.toCharArray();
        boolean dp[][]=new boolean[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = true;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (ch[i] != ch[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max= j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }


}
