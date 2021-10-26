/**496. 下一个更大元素 I
给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。

请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。*/
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []result =new int[nums1.length];
        for(int i = 0 ;i< nums1.length;i++){
            boolean find = false;
            boolean add = false;
            for(int j :nums2){
                if(j==nums1[i]){
                    find = true;
                    continue;
                }
                if(find&&j>nums1[i]){
                    result[i] = j;
                    add = true;
                    break;
                }
            }
           if(!add) result[i] = -1;
        }
        return result;
    }
}
/**https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
 *官方单调栈的代码，代码容易理解
 * class Solution {
 *     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
 *         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
 *         Deque<Integer> stack = new ArrayDeque<Integer>();
 *         for (int i = nums2.length - 1; i >= 0; --i) {
 *             int num = nums2[i];
 *             while (!stack.isEmpty() && num >= stack.peek()) {
 *                 stack.pop();
 *             }
 *             map.put(num, stack.isEmpty() ? -1 : stack.peek());
 *             stack.push(num);
 *         }
 *         int[] res = new int[nums1.length];
 *         for (int i = 0; i < nums1.length; ++i) {
 *             res[i] = map.get(nums1[i]);
 *         }
 *         return res;
 *     }
 * }
 *
 *
 *
 * */