package 剑指offer;
/**
 * 剑指 Offer II 097. 子序列的数目
 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

 题目数据保证答案符合 32 位带符号整数范围。



 示例 1：

 输入：s = "rabbbit", t = "rabbit"
 输出：3
 解释：
 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 rabbbit
 rabbbit
 rabbbit
 示例 2：

 输入：s = "babgbag", t = "bag"
 输出：5
 解释：
 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 babgbag
 babgbag
 babgbag
 babgbag
 babgbag

 */
public class OfferII97 {



    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        if(sLen<tLen)
            return 0;
        for (int i = 0;i<=sLen;i++)
            dp[i][tLen] = 1;

        for (int i = sLen-1;i>=0;i--){
            for (int j = tLen-1;j>=0;j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+dp[i+1][j];
                }else dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }}









    //TLE
//    String s;
//    String t;
//    int count = 0;
//    public int numDistinct(String s, String t) {
//        this.s = s;
//        this.t = t;
//        backtrack("",0);
//        return count;
//    }
//    void backtrack(String path,int start){
//        if(path.length()>0&&!path.startsWith(t.substring(0,path.length())))
//            return;
//        if(path.length() == s.length()){
//            if(path.equals(s)){
//                count++;
//            }
//            return;
//        }
//        for (int i = start;i<s.length();i++){
//            backtrack(new String(path+s.charAt(i)),i+1);
//        }
//
//    }


