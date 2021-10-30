package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



 示例 1：

 输入：nums = [2,7,11,15], target = 9
 输出：[2,7] 或者 [7,2]
 示例 2：

 输入：nums = [10,26,30,31,47,60], target = 40
 输出：[10,30] 或者 [30,10]
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i :nums){
            if(set.contains(target-i)){
                return new int[]{i,target-i};
            }
            set.add(i);
        }
        return new int[]{0,0};
    }
}
/**注意本题的 numsnums 是 排序数组 ，因此可使用 双指针法 将空间复杂度降低至 O(1)O(1) 。

 算法流程：
 初始化： 双指针 ii , jj 分别指向数组 numsnums 的左右两端 （俗称对撞双指针）。
 循环搜索： 当双指针相遇时跳出；
 计算和 s = nums[i] + nums[j]s=nums[i]+nums[j] ；
 若 s > targets>target ，则指针 jj 向左移动，即执行 j = j - 1j=j−1 ；
 若 s < targets<target ，则指针 ii 向右移动，即执行 i = i + 1i=i+1 ；
 若 s = targets=target ，立即返回数组 [nums[i], nums[j]][nums[i],nums[j]] ；
 返回空数组，代表无和为 targettarget 的数字组合。

 作者：jyd
 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/