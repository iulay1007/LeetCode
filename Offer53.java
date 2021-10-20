package 剑指offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Offer53 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        sum = (nums.length) * ((nums.length + 1) / 2) + ((nums.length + 1) % 2) * (nums.length / 2);
        int count = 0;
        for (int i : nums) {
            count += i;
        }
        return sum - count;
    }
}