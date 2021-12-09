package 剑指offer;
/**剑指 Offer II 070. 排序数组中只出现一次的数字
 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。



 示例 1:

 输入: nums = [1,1,2,3,3,4,4,8,8]
 输出: 2
 示例 2:

 输入: nums =  [3,3,7,7,10,11,11]
 输出: 10




 提示:

 1 <= nums.length <= 105
 0 <= nums[i] <= 105


 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？

 */
public class OfferII70 {
    public int singleNonDuplicate(int[] nums) {
        int num =0;
        for(int n :nums){
            num=num^n;
        }
        return num;
    }

}
/**首先我们得想到二分，但是要做到这一点感觉需要一定的刷题经验，比如看到查找目标值、有序、时间复杂度O(logn)等信息，大概率就是二分了。

 其次我们再来回答以下问题，

 数组的特征？
 数组长度为奇数
 递增排列
 只有一个数数量为1，其余为2
 每一对数字的下标要么是(奇数，偶数)，要么是(偶数，奇数)
 目标值的特征？
 只有一个，也就是说它跟前后两个都不相同
 二分查找过程中中间值nums[mid]的特征？有三种情况
 它跟它后面一个数字相同
 它跟它前面一个数字相同
 它就是答案
 如何判断答案在哪一个可行区间内，也就是如何淘汰不可能的答案？
 前面提到了下标的奇偶性，聪明的你一定想到了二分的关键，那就是如果mid所对应的一对数字下标是(奇数，偶数)，那么目标一定在mid之前，如果下标是(偶数，奇数)，目标一定在mid之后

 class Solution {
 public int singleNonDuplicate(int[] nums) {
 int n = nums.length, l = 0, r = n - 1;
 int ans = -1;
 while (l <= r) {
 int mid = l + (r - l) / 2;
 if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
 if (mid % 2 == 0) {
 l = mid + 2;
 } else {
 r = mid - 1;
 }
 } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
 if (mid % 2 == 0) {
 r = mid - 2;
 } else {
 l = mid + 1;
 }
 } else {
 ans = nums[mid];
 break;
 }
 }
 // 由于题目的性质，ans一定会被找到，所以不会返回-1
 return ans;
 }
 }
*/
