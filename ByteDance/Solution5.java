package 剑指offer.ByteDance;

import java.util.ArrayList;
import java.util.List;
/**
 * 设计并实现一个迭代压缩字符串的数据结构。给定的压缩字符串的形式是，每个字母后面紧跟一个正整数，表示该字母在原始未压缩字符串中出现的次数。

 设计一个数据结构，它支持如下两种操作： next 和 hasNext。

 next() - 如果原始字符串中仍有未压缩字符，则返回下一个字符，否则返回空格。
 hasNext() - 如果原始字符串中存在未压缩的的字母，则返回true，否则返回false。


 示例 1：

 输入：
 ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
 [["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
 输出：
 [null, "L", "e", "e", "t", "C", "o", true, "d", true]

 解释：
 StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
 stringIterator.next(); // 返回 "L"
 stringIterator.next(); // 返回 "e"
 stringIterator.next(); // 返回 "e"
 stringIterator.next(); // 返回 "t"
 stringIterator.next(); // 返回 "C"
 stringIterator.next(); // 返回 "o"
 stringIterator.hasNext(); // 返回 True
 stringIterator.next(); // 返回 "d"
 stringIterator.hasNext(); // 返回 True
 */
public class Solution5 {
    class StringIterator {
        StringBuilder str;
        List<Integer> count = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        public StringIterator(String compressedString) {
            str = new StringBuilder(compressedString);
            for (int i = 0; i < compressedString.length(); i++) {
                if(compressedString.charAt(i)<'0'||compressedString.charAt(i)>'9')
                {
                    chars.add(compressedString.charAt(i));
                }else {
                    int start = i;
                    while (i+1<compressedString.length()&&(compressedString.charAt(i+1)>='0'&&compressedString.charAt(i+1)<='9')){
                        i++;
                    }
                    count.add(Integer.parseInt(compressedString.substring(start,i+1)));

                }
            }
        }

        public char next() {
            if(!count.isEmpty()&&count.get(0)!=0){
                count.set(0,count.get(0)-1);
                char res = chars.get(0);
                if(count.get(0) == 0)
                {
                    count.remove(0);
                    chars.remove(0);
                }

                return res;
            }
            return ' ';
        }

        public boolean hasNext() {
            for (int i = 0;i<count.size();i++){
                if(count.get(i)!=0)
                    return true;
            }
            return false;
        }
    }

}
