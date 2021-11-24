package 剑指offer;
/**713. 乘积小于K的子数组
 给定一个正整数数组 nums和整数 k 。

 请找出该数组内乘积小于 k 的连续的子数组的个数。



 示例 1:

 输入: nums = [10,5,2,6], k = 100
 输出: 8
 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 示例 2:

 输入: nums = [1,2,3], k = 0
 输出: 0
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int i=0,j = 1;
        int temp =nums[0];
        while (i<j&&j<nums.length){
            while (temp<k) {
                res++;

                while(j<nums.length&&nums[j]==1){
                    j++;
                    res++;
                }
                if(j == nums.length)
                    break;
                temp*=nums[j];
                j++;
            }
            i++;
            j=i+1;
            temp=nums[i];
        }
        if(nums[i]<k)
            res++;

        return res;
    }

/**
 *  public int numSubarrayProductLessThanK(int[] nums, int k) {
 if (k <= 1) return 0;
 int prod = 1, ans = 0, left = 0;
 for (int right = 0; right < nums.length; right++) {
 prod *= nums[right];
 while (prod >= k) prod /= nums[left++];
 ans += right - left + 1;
 }
 return ans;
 }
 */
}
