import java.util.ArrayList;
import java.util.List;
/**500. 键盘行
 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。

 美式键盘 中：

 第一行由字符 "qwertyuiop" 组成。
 第二行由字符 "asdfghjkl" 组成。
 第三行由字符 "zxcvbnm" 组成。
 American keyboard



 示例 1：

 输入：words = ["Hello","Alaska","Dad","Peace"]
 输出：["Alaska","Dad"]
 示例 2：

 输入：words = ["omk"]
 输出：[]
 示例 3：

 输入：words = ["adsdf","sfd"]
 输出：["adsdf","sfd"]*/
//用HashSet也可以
public class Solution500 {
    String[] str = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
    List<String> result = new ArrayList<>();
    public String[] findWords(String[] words) {
        int row = 0;
        for(String s:words){
            for(int i = 0;i< s.length();i++){
                if(i==0)
                {
                    row=getChatAtRow(s.charAt(i));
                }
                if(i!=0&&row!=getChatAtRow(s.charAt(i)))
                    break;
                if(i == s.length()-1)
                    result.add(s);
            }
        }
        String [] resultStr = new String[result.size()];
       return result.toArray(resultStr);
    }

    int getChatAtRow(char c){
        c=Character.toLowerCase(c);
        if(str[0].contains(c+""))
            return 1;
        else if(str[1].contains(c+""))
            return 2;
        else return 3;
    }

}
