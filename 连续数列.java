import java.util.Arrays;

/*
面试题 16.17. 连续数列
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/
public class 连续数列 {
    public int maxSubArray(int[] nums) {
            if(nums.length==0)
                return nums[0];
            int [] dp= Arrays.stream(nums).toArray();
            int max=dp[0];
            for(int i=1;i<nums.length;i++)
            {
                dp[i]=Math.max(dp[i],dp[i]+dp[i-1]);
                max=Math.max(dp[i],max);
            }
            return max;
    }
}