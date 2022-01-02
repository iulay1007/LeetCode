package 剑指offer;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if(haystack.isEmpty()) return -1;
        int[][] dp = getDp(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            int cur = getChNum(haystack.charAt(i));
            j = dp[j][cur];
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }

    int[][] getDp(String str) {
        int[][] dp = new int[str.length()][52];
        dp[0][getChNum(str.charAt(0))] = 1;
        int X = 0;
        for (int i = 1; i < str.length(); i++) {
            int cur = getChNum(str.charAt(i));
            for (int j = 0; j < 52; j++) {
                if (j == cur) {
                    dp[i][j] = i + 1;
                } else {
                    dp[i][j] = dp[X][j];
                }

            }
            char ch = str.charAt(i);
            X = dp[X][getChNum(ch)];
        }
        return dp;
    }
    int getChNum(char c){
        if (c > 96) {
            return c - 97 + 26;
        } else {
            return c - 65;
        }
    }

   }