package 剑指offer;

import java.util.Arrays;


/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * <p>
 * 提示：
 */
public class Solution698 {
    int [] bucket ;
    int [] nums;
    int n;
    int size;
    int k;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0)
            return false;
        size = nums.length;
        Arrays.sort(nums);
        this.n = sum / k;
        this.bucket = new int[k];
        this.nums = nums;
        this.k = k;
      return   backtrack(0);

    }

    boolean backtrack(int index){
        if(index ==size) {
            for (int j =0;j<k;j++){
                if(bucket[j] != n)
                    return false;
            }
            return true;
        }
        if(nums[size-index-1] >n)
            return false;
        for (int i = 0;i<k;i++){
            if(bucket[i]+nums[size-index-1]>n)
                continue;
            bucket[i]+=nums[size-index-1];
            if(backtrack(index+1)) return true;
            bucket[i]-=nums[size-index-1];
        }
        return false;
    }
}