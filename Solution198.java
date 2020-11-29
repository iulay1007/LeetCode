/*
*198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
  */
public class Solution198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        else if (nums.length == 1)
            return nums[0];

        else if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
/*考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。

JavaC++Python3Golang

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
*/
/*我写的错误的代码！！！！！！！
class Solution {
    public int rob(int[] nums) {
        int dp []=new int[nums.length+1];
        int max=0;
        int temp=0;
        if(nums.length==0)
        return 0;
        else if(nums.length==1)
        return nums[0];
        else if(nums.length==2)
        return Math.max(nums[0],nums[1]);
        dp[0]=nums[0]+find(nums,2);
        dp[1]=nums[1]+find(nums,3);
        temp=Math.max(dp[0],dp[1]);
        for(int i=2;i<nums.length-2;i++)

        {
           dp[i]=dp[i-2]+find(nums,i+2);
           max=Math.max(temp,dp[i]);
           temp=dp[i];
        }
        max=Math.max(dp[nums.length-2],max);
        max=Math.max(dp[nums.length-1],max);
        return max;
    }
    public int find(int [] nums,int position){
            int result=0;
            if(position>nums.length)
            return 0;
            else if(position+1==nums.length)
            return nums[position];
            else if(position+1>nums.length)
            return 0;
            else
            {
            result=Math.max(nums[position],nums[position+1]);
            return Math.max(find(nums,position+2),result);
            }


    }
}*/