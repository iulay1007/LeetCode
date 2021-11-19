package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**给定一个正整数 n ，你可以做如下操作：

 如果 n 是偶数，则用 n / 2替换 n 。
 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 n 变为 1 所需的最小替换次数是多少？

  

 示例 1：

 输入：n = 8
 输出：3
 解释：8 -> 4 -> 2 -> 1
 示例 2：

 输入：n = 7
 输出：4
 解释：7 -> 8 -> 4 -> 2 -> 1
 或 7 -> 6 -> 3 -> 2 -> 1
 示例 3：

 输入：n = 4
 输出：2
*/
public class Solution397 {
    Map<Long,Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
             return helper(n);
    }

    int helper(long n){
        if( n == 1)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        int res = 0;
        if( n%2 == 0)
            res =  helper(n/2) +1;
        else {
            res = 1+Math.min(helper(n+1),helper(n-1));
        }
        map.put(n,res);
        return res;
    }

    }

/**二进制时，偶数最后一位一定是0，奇数一定是1，这题主要的问题是单n为奇数时，是++还是--？只要n能够多变成偶数才能更快的减小，所以要使得n变成偶数的次数多
 例：
 最后两位是11，加一 1011 -> 1100 -> 0110 -> 0011 (注意：当n等于3时直接减一)-> 0010 -> 0001
 最后两位是01，减一 1101 -> 1100 -> 0110 -> 0011 -> 0010 -> 0001

 代码

 class Solution {
 public int integerReplacement(int n) {
 long temp = n;
 int result = 0;
 while (temp != 1){
 if ((temp & 1) == 0){
 temp >>= 1;
 }else if (temp != 3){
 temp = (temp & 3) == 3 ? temp+1:temp-1;
 }else {
 temp--;
 }
 result++;
 }
 return result;
 }
 }

 */