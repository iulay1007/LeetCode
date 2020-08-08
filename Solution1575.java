/*
剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

*/

class Solution1575 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
           
            if (nums[i] != i) {
                return i;
            }
        }
        return length;
    }
}
