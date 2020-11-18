import java.util.Stack;
/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
执行用时：
1 ms
, 在所有 Java 提交中击败了
98.84%
的用户
内存消耗：
36.4 MB
, 在所有 Java 提交中击败了
93.35%
的用户
*/
//思路简单但是代码比较冗杂？
public class Solution20 {
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        //！改进成%2
        if(s.length()%2==1)
            return false;
        Stack stack=new Stack<Character>();
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='('||ch[i]=='{'||ch[i]=='[')
                stack.push(ch[i]);
            else if(ch[i]==')'||ch[i]=='}'||ch[i]==']')
            {
                if(stack.isEmpty())
                    return false;
                char temp= (char) stack.pop();
                switch (ch[i])
                {
                    case ')':if(temp=='(') break;
                    else return false;

                    case '}':if(temp=='{') break;
                    else return false;

                    case ']':
                        if(temp=='[') break;
                        else return false;


                }
            }

        }
     /*   if(stack.isEmpty())
            return true;
        return false;*/
        //改为
        return stack.isEmpty();
    }
}


/*
别人的代码
class Solution {
public:
    bool isValid(string s) {
        stack<char> stack;
        for(int i=0; i<s.length(); ++i){
            char c = s[i];
            if(!stack.empty()){
                char t = stack.top();
                if(t=='(' && c==')'
                    || t=='[' && c==']'
                    || t=='{' && c=='}'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.empty();
    }
};*/