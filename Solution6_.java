package 剑指offer;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class Solution6_ {
    public String convert(String s, int numRows) {
        String[] str = new String[numRows];
        boolean type =  true;
        int pos = 0;
        for (int i =0;i<s.length();i++){
            if(str[pos] == null)
                str[pos] = "";
            str[pos]+=s.charAt(i);
            if(pos == numRows-1&& type){
                type =false;
            }
            else if(pos == 0&& !type){
                type = true;
            }
            if(type){
                if(pos+1<numRows)
                    pos++;
            }else {
                if(pos-1>=0)
                    pos--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i =0;i<numRows;i++){
            System.out.println(str[i]);
            if(str[i]!=null)
                res.append(str[i]);
        }
        return res.toString();
    }

}

/**方法二：按行访问
 思路

 按照与逐行读取 Z 字形图案相同的顺序访问字符串。

 算法

 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...

 对于所有整数 kk，

 行 00 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2) 处;
 行 \text{numRows}-1numRows−1 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1 处;
 内部的 行 ii 中的字符位于索引 k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i 以及 (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i 处;

 作者：LeetCode
 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 class Solution {
 public String convert(String s, int numRows) {

 if (numRows == 1) return s;

 StringBuilder ret = new StringBuilder();
 int n = s.length();
 int cycleLen = 2 * numRows - 2;

 for (int i = 0; i < numRows; i++) {
 for (int j = 0; j + i < n; j += cycleLen) {
 ret.append(s.charAt(j + i));
 if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
 ret.append(s.charAt(j + cycleLen - i));
 }
 }
 return ret.toString();
 }
 }


 */