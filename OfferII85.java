package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer II 085. 生成匹配的括号
 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



 示例 1：

 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 示例 2：

 输入：n = 1
 输出：["()"]


 提示：

 1 <= n <= 8*/
public class OfferII85 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),0,0,n);
        return res;
    }
    void backtrack(StringBuilder path,int l ,int r ,int n ){
        if(l < r || l > n) return;
        if(l==n&&r==n){
            res.add(path.toString());
            return;
        }

        path.append('(');
        backtrack(path,l+1,r,n);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        backtrack(path,l,r+1,n);
        path.deleteCharAt(path.length() - 1);

    }
}
