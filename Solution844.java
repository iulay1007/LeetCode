import java.util.Stack;
/*844. 比较含退格的字符串
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。



示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
示例 2：

输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
示例 3：

输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
示例 4：

输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。*/

/*那么本题，确实可以使用栈的思路，但是没有必要使用栈，因为最后比较的时候还要比较栈里的元素，有点麻烦。

这里直接使用字符串string，来作为栈，末尾添加和弹出，string都有相应的接口，最后比较的时候，只要比较两个字符串就可以了，比比较栈里的元素方便一些
*/
public class Solution844 {

    public boolean backspaceCompare(String S, String T) {
        char s[];
        char t[];
        s=S.toCharArray();
        t=T.toCharArray();
        Stack sstack=new Stack<>();
        Stack tstack=new Stack<>();
        for(int i=0;i<s.length;i++)
        {
            if (s[i]=='#'&&sstack.isEmpty())
                continue;
            if(s[i]=='#')
            sstack.pop();
            else
            sstack.push(s[i]);
        }

        for(int i=0;i<t.length;i++)
        {
            if (t[i]=='#'&&tstack.isEmpty())
                continue;
            if(t[i]=='#')
                tstack.pop();
            else
                tstack.push(t[i]);
        }
        while (sstack.isEmpty()==false&&tstack.isEmpty()==false)
        {
            if(sstack.pop()!=tstack.pop())
                return false;
        }

        return sstack.isEmpty()&&tstack.isEmpty();
    }
}

/*用合理的数据结构的重要性
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
*/

/*方法二：双指针
思路及算法

一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。

具体地，我们定义skip 表示当前待删除的字符的数量。每次我们遍历到一个字符：

若该字符为退格符，则我们需要多删除一个普通字符，我们让 skip 加 1；

若该字符为普通字符：

若 skip 为 0，则说明当前字符不需要删去；

若skip 不为 0，则说明当前字符需要删去，我们让 skip 减 1。

这样，我们定义两个指针，分别指向两字符串的末尾。每次我们让两指针逆序地遍历两字符串，直到两字符串能够各自确定一个字符，然后将这两个字符进行比较。重复这一过程直到找到的两个字符不相等，或遍历完字符串为止。


链接：https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode-solu/
。
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

*/