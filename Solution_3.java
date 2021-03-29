import java.util.List;
/*3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0*/
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1)
            return 1;
        String str="";
        System.out.println(str.length());
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            str=s.charAt(i)+"";
            for(int j=i+1;j<s.length();j++)
            {
                if(str.contains(s.charAt(j)+"")==false)
                    str+=s.charAt(j);
                else
                    break;

            }
            max = Math.max(str.length(),max);
        }
        return max;
    }
}

/*滑动窗口
思路和算法

我们先用一个例子考虑如何在较优的时间复杂度内通过本题。

我们不妨以示例一中的字符串 \abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：

以 {(a)bcabcbb}(a)bcabcbb 开始的最长字符串为 \texttt{(abc)abcbb}(abc)abcbb；
以 {a(b)cabcbb}a(b)cabcbb 开始的最长字符串为 \texttt{a(bca)bcbb}a(bca)bcbb；
以 {ab(c)abcbb}ab(c)abcbb 开始的最长字符串为 \texttt{ab(cab)cbb}ab(cab)cbb；
以 {abc(a)bcbb}abc(a)bcbb 开始的最长字符串为 \texttt{abc(abc)bb}abc(abc)bb；
以 {abca(b)cbb}abca(b)cbb 开始的最长字符串为 \texttt{abca(bc)bb}abca(bc)bb；
以 {abcab(c)bb}abcab(c)bb 开始的最长字符串为 \texttt{abcab(cb)b}abcab(cb)b；
以 {abcabc(b)b}abcabc(b)b 开始的最长字符串为 \texttt{abcabc(b)b}abcabc(b)b；
以 {abcabcb(b)}abcabcb(b) 开始的最长字符串为 \texttt{abcabcb(b)}abcabcb(b)。
发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 kk 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 r_kr
k
​
 。那么当我们选择第 k+1k+1 个字符作为起始位置时，首先从 k+1k+1 到 r_kr
k
​
  的字符显然是不重复的，并且由于少了原本的第 kk 个字符，我们可以尝试继续增大 r_kr
k
​
 ，直到右侧出现了重复字符为止。
*/