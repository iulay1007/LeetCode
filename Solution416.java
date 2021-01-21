/*416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.*/
public class Solution416 {
    public boolean canPartition(int[] nums) {
        if(nums.length==0)
            return true;
        int sum=0;
        for(int i=0;i< nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        int count=sum/2;
        boolean dp[][]=new boolean[nums.length+1][count+1];
        for(int i=0;i<=count;i++) {

            dp[0][i]=false;
        }
        for(int i=0;i<=nums.length;i++)
            dp[i][0]=true;

        for(int i=1;i<=nums.length;i++)
            for(int j=1;j<=count;j++)
            {
                if(j-nums[i-1]<0)
                    dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
            }
        return dp[nums.length][count];
    }
}