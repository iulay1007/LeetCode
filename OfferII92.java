package 剑指offer;
/**
 * 剑指 Offer II 092. 翻转字符
 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。

 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。

 返回使 s 单调递增 的最小翻转次数。



 示例 1：

 输入：s = "00110"
 输出：1
 解释：我们翻转最后一位得到 00111.
 示例 2：

 输入：s = "010110"
 输出：2
 解释：我们翻转得到 011111，或者是 000111。
 示例 3：

 输入：s = "00011000"
 输出：2
 解释：我们翻转得到 00000000。

 1 <= s.length <= 20000
 s 中只包含字符 '0' 和 '1'
 */
public class OfferII92 {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        if(s.charAt(0) == '0'){
            dp[0][0] = 0;
            dp[0][1] = 1;
        }else {
            dp[0][0] = 1;
            dp[0][1] = 0;
        }

        for (int i = 1;i<s.length();i++){
            if(s.charAt(i) == '0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0])+1;
            }else {
                dp[i][1] =  Math.min(dp[i-1][1],dp[i-1][0]);
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }
    public int minFlipsMonoIncr2(String s) {
        int num1;
        int num2;
        if(s.charAt(0) == '0'){
            num1 = 0;
            num2 = 1;
        }else {
            num1 = 1;
            num2 = 0;
        }
        int temp1,temp2;

        for (int i = 1;i<s.length();i++){
            if(s.charAt(i) == '0'){
                temp1= num1;
                temp2 = Math.min(num1,num2)+1;
            }else {
               temp2=   Math.min(num1,num2);
                temp1 = num1+1;
            }

            num1 = temp1;
            num2 = temp2;
        }
        return Math.min(num1,num2);
    }

    /**class Solution {
     public int minFlipsMonoIncr(String s) {
     int n = s.length();
     int one = 0, zero = 0;
     for(char c : s.toCharArray()){
     if(c == '0') one = Math.min(zero, one) + 1;
     else if(c == '1'){
     one = Math.min(zero, one);
     zero++;
     }
     }
     return Math.min(one, zero);
     }
     }

   */
    }