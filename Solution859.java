package 剑指offer;

/**859. 亲密字符串
 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。

 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。

 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。


 示例 1：

 输入：s = "ab", goal = "ba"
 输出：true
 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 示例 2：

 输入：s = "ab", goal = "ab"
 输出：false
 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 示例 3：

 输入：s = "aa", goal = "aa"
 输出：true
 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 示例 4：

 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 输出：true*/
public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        if(s ==null ||goal ==null ||(s.length()!=goal.length()))
            return false;
        if(s.equals(goal))
        {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }}
        int count = 0;
        char[] sCh = s.toCharArray();
        char[] gCh = goal.toCharArray();
        int a = 0, b = 0;
        for(int i = 0;i<s.length();i++){
            if(sCh[i]!=gCh[i])
            {
                if(count == 0)
                    a=i;
                else if(count ==1)
                    b=i;
                else return false;
                count++;
            }

            if(count == 2){

                if(sCh[a] == gCh[b] &&sCh[b] == gCh[a]) {
                    continue;
                }else return false;
            }

        }
        if(count == 2)  return true;
        else return false;

    }

}
