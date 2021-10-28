package 剑指offer;

import java.util.*;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



 示例 1:

 输入: 12258
 输出: 5
 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


 提示：

 0 <= num < 231*/
public class Offer46 {
    Set<String> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    public int translateNum(int num) {
       while (num!=0){
           list.add(num%10);
           num = num/10;
       }

     backtrack(0,"");
       return set.size();
}

void backtrack(int i,String str){
        if(i>=list.size()) {
            set.add(str);
            return;}
        String temp = str;
        str = str+ getChar(list.get(i));
        backtrack(i+1,str);
        str = temp;
        if(i+1<list.size()&&(list.get(i+1)==1||list.get(i+1)==2)){
            if(list.get(i+1)*10+list.get(i)<26){
            str = str+getChar(list.get(i+1)*10+list.get(i));
            backtrack(i+2,str);}
        }
}


    char getChar(int num){
        return (char) ('a'+(num));
    }
}
/*别人的解法
 public int translateNum(int num) {
 if (num <= 9)
 return 1;
 else if (num <= 25){
 return 2;
 }

 int a = num % 100;
 if (a <= 25 && a >9)
 return translateNum(num/10) + translateNum(num/100);
 else return translateNum(num/10);
 }*/