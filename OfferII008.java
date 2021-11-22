package 剑指offer;
/**剑指 Offer II 008. 和大于等于 target 的最短子数组
 给定一个含有 n 个正整数的数组和一个正整数 target 。

 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



 示例 1：

 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 示例 2：

 输入：target = 4, nums = [1,4,4]
 输出：1
 示例 3：

 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 输出：0
 */
//关键是它是一个正整数数组
public class OfferII008 {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0 ) return 0;
        int result = nums.length;
        int []sum = new int[nums.length];
        for(int i = 0;i< nums.length;i++){
            if(nums[i]>=target) return 1;
            if(i == 0)
            {
                sum[i]=nums[0];
                continue;
            }
            sum[i] =sum[i-1]+nums[i];
            if(sum[i]>=target){
                result = Math.min(result,i+1);
            }
        }
        if (sum[nums.length-1] <target) return 0;
        if(result == 2 ) return 2;
        for(int i = 1;i<nums.length;i++){
            for(int j = i-2; j>0;j--){
                if((i-j)>=result)
                    break;
                if(sum[i]-sum[j]>=target){
                    result =i-j;
                    break;
                }
            }
        }
        return result;

    }}

/**
滑动窗口，有两个边界，一个左边界，一个右边界，开始的时候，左右边界都指向数组的首位置
        由于目标是找出大于或等于target的最短数组；用一个值来记录窗口内数字的和
        如果两个指针之间的子数组中所有数字之和小于target，那么把右边界向右移动
        滑动窗口的总体思路是先移动右边界，让窗口中的值满足题目的解，也在是说在找到可行解的情况下
        再移动左边界，在可行解里面寻找最优解
        具体滑动窗口可见：图解滑动窗口：一步步解释滑动窗口通用解题套路
        代码
 *@param {number} target
 * @param {number[]} nums
 * @return {number}

        var minSubArrayLen = function(target, nums) {
        let left = 0,
        sum = 0;
        let minLength = Number.MAX_VALUE;
        for (let right = 0; right < nums.length; right++) {
        // 由于数组中的所有数字都是正整数，因此在子数组中添加新的数字能得到更大的子数组之和
        sum += nums[right];
        // sum>=target 已经是找到了可行解了
        while (left <= right && sum >= target) {
        //  移动左边界，在可行解里面寻找最优解
        minLength = Math.min(minLength, right - left + 1);
        sum -= nums[left++];
        }
        }
        return minLength == Number.MAX_VALUE ? 0 : minLength;
        };

       */
