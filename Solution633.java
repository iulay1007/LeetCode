/*633. 平方数之和
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

 

示例 1：

输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
示例 2：

输入：c = 3
输出：false
示例 3：

输入：c = 4
输出：true
示例 4：

输入：c = 2
输出：true
示例 5：

输入：c = 1
输出：true
 */
public class Solution633 {
    public boolean judgeSquareSum(int c) {

        int temp=0;
        for(int i=0;i<=c/2;i++){
            temp=c-i*i;
            if(temp<0)
                return false;
            if(Math.sqrt(temp)==(int)Math.sqrt(temp))
                return true;
        }
        return false;
    }}
    //也可以用双指针，快了一点
/* public boolean judgeSquareSum(int c) {
           long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }*/