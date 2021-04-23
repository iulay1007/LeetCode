import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。



示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

"3[a2[c]]"
"accaccacc"
*/
public class Solution394 {
    String result="";
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> stack=new Stack<>();
        int fast=0;
        int len;
        String temp;
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            len=1;
            fast=i+1;
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')
            {
                while (s.charAt(fast)!='[')
                {
                    fast++;
                    len++;
                }
                len=Integer.parseInt(s.substring(i,i+len));
                numStack.push(len);
                i=fast-1;
            }
            else if(s.charAt(i)==']'){
                temp="";
                while (!stack.isEmpty())
                    if(stack.peek()!='[')
                        temp=stack.pop()+temp;
                    else if(stack.peek()=='['){
                        stack.pop();
                        break;}
                num=numStack.pop();
                System.out.println(temp);
                System.out.println(num);
                for(int k=0;k<num;k++){
                    for(int j=0;j<temp.length();j++)
                    {
                        System.out.println(temp.charAt(j));
                        System.out.println(stack.size());
                        stack.push(temp.charAt(j));

                    }
                }

            }
            else
                stack.push(s.charAt(i));
        }
        int size=stack.size();
        for(int k=0;k<size;k++)
        {
            System.out.println(stack.peek());
            result=stack.pop()+result;
        }

        return result;
    }
}