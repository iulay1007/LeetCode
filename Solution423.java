package 剑指offer;

import java.util.HashMap;
import java.util.Map;
/**423. 从英文中重建数字
 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。



 示例 1：

 输入：s = "owoztneoer"
 输出："012"
 示例 2：

 输入：s = "fviefuro"
 输出："45"


 提示：

 1 <= s.length <= 105
 s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 s 保证是一个符合题目要求的字符串
 */
//有点水的题，没有什么算法。随便写的。不想优化了
public class Solution423 {
    public String originalDigits(String s) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Integer,Integer> num = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        if (map.getOrDefault('w',0)!=0){
            int n = map.get('w');
            num.put(2,n);
            map.remove('w');
            map.put('t',map.get('t')-n);
            map.put('o',map.get('o')-n);
        }
        if (map.getOrDefault('x',0)!=0){
            int n = map.get('x');
            num.put(6,n);
            map.remove('x');
            map.put('i',map.get('i')-n);
            map.put('s',map.get('s')-n);
        }

        if(map.getOrDefault('s',0)!=0){
            int n = map.get('s');
            num.put(7,n);
            map.remove('s');
            map.put('e',map.get('e')-2*n);
            map.put('v',map.get('v')-n);
            map.put('n',map.get('n')-n);
        }

        if(map.getOrDefault('v',0)!=0){
            int n = map.get('v');
            num.put(5,n);
            map.remove('v');
            map.put('f',map.get('f')-n);
            map.put('i',map.get('i')-n);
            map.put('e',map.get('e')-n);
        }

        if(map.getOrDefault('f',0)!=0){
            int n = map.get('f');
            num.put(4,n);
            map.remove('f');
            map.put('o',map.get('o')-n);
            map.put('u',map.get('u')-n);
            map.put('r',map.get('r')-n);
        }

        if(map.getOrDefault('g',0)!=0){
            int n = map.get('g');
            num.put(8,n);
            map.remove('g');
            map.put('i',map.get('i')-n);
            map.put('e',map.get('e')-n);
            map.put('h',map.get('h')-n);
            map.put('t',map.get('t')-n);
        }

        if(map.getOrDefault('h',0)!=0){
            int n = map.get('h');
            num.put(3,n);
            map.remove('h');
            map.put('t',map.get('t')-n);
            map.put('e',map.get('e')-2*n);
            map.put('r',map.get('r')-n);
        }

        if(map.getOrDefault('t',0)!=0){
            int n = map.get('t');
            num.put(10,n);
            map.remove('t');
            map.put('e',map.get('e')-n);
            map.put('n',map.get('n')-n);
        }

        if(map.getOrDefault('i',0)!=0){
            int n = map.get('i');
            num.put(9,n);
            map.remove('i');
            map.put('e',map.get('e')-n);
            map.put('n',map.get('n')-2*n);
        }
        num.put(1,map.getOrDefault('n',0));
        num.put(0,map.getOrDefault('z',0));

        StringBuilder res = new StringBuilder();
        for(int i = 0;i<=10;i++){
            if(num.containsKey(i)){
                for(int j = 1;j<=num.get(i);j++){
                    res.append(i);
                }
            }
        }
        return res.toString();
    }

}
