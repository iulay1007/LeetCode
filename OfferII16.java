package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**剑指 Offer II 016. 不含重复字符的最长子字符串
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。



 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 示例 4:

 输入: s = ""
 输出: 0
 */
public class OfferII16 {

    public int lengthOfLongestSubstring(String s) {
    if(s == null ||s.length() == 0)
        return 0;
    int res = 0;
    int i = 0;
    Set<Character> set = new HashSet<>();
    for(int j  = 0;j<s.length();j++){
        if(!set.contains(s.charAt(j))){
            set.add(s.charAt(j));
        }else {
            while (s.charAt(i)!=s.charAt(j)){
                set.remove(s.charAt(i));
                i++;
            }
            i++;
        }
        res = Math.max(res,set.size());

    }
    return res;
    }

}
