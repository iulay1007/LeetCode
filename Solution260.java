/**
 * 260. 只出现一次的数字 III
 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。



 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？



 示例 1：

 输入：nums = [1,2,1,3,2,5]
 输出：[3,5]
 解释：[5, 3] 也是有效的答案。
 示例 2：

 输入：nums = [-1,0]
 输出：[-1,0]
 示例 3：

 输入：nums = [0,1]
 输出：[1,0]
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int xorNum = 0;
        for (int num : nums)
            xorNum ^= num;
        int bit = xorNum & -xorNum;
        int x = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                x ^= num;
            }
        }

        return new int[] {x, x^xorNum};
}
}
/**方法、位运算
 我们知道位运算满足以下规则：

 x ^ x == 0，即自己跟自己异或的结果为 0；
 x ^ 0 == x，即自己跟 0 的异或结果还是自己；
 0 ^ 1 == 1，0 ^ 0 = 0，1 ^ 1 = 0；
 所以，本题我们可以使用异或来求解，对于一组数中的其他数都出现两次，唯独有两个数只出现一次，所以，所有数异或的结果肯定不为 0。

 因为结果不为 0 ，所以，我们可以取出二进制中不为 0 的那位，比如为第 x 位，将所有的数分成两个部分，即第 x 位为 0 的数和第 x 位不为 0 的数。

 这里再仔细想想，因为异或的结果不为 0，而不为 0 是那两个只出现一次的数贡献的，根据上面第三条规则，这两个数肯定有某位不同，所以，我们可以按照这个不同的位将两个数分到两边，对于一边来说，它们所有的数异或的结果就是一个只出现一次的数，同样地，另一边所有数异或的结果就是另一个只出现一次的数。

 好了，让我们来看代码：


 class Solution {
 public int[] singleNumber(int[] nums) {
 // 所有数异或的结果
 int xor = 0;
 for (int num : nums) {
 xor ^= num;
 }

 // 取出不同的那个位，我们这里取最右边的那个1
 int bit = xor & (-xor);

 // 按这个位将所有数分成两半分别异或的结果就是我们要找的那两个数
 int x = 0, y = 0;
 for (int num : nums) {
 if ((num & bit) == 0) {
 x ^= num;
 } else {
 y ^= num;
 }
 }

 // 构造返回值
 return new int[] {x, y};
 }
 }
*/