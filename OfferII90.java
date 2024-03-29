package 剑指offer;
/**剑指 Offer II 090. 环形房屋偷盗
 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。



 示例 1：

 输入：nums = [2,3,2]
 输出：3
 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 示例 2：

 输入：nums = [1,2,3,1]
 输出：4
 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 偷窃到的最高金额 = 1 + 3 = 4 。
 示例 3：

 输入：nums = [0]
 输出：0*/
public class OfferII90 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0],nums[1]);
        else if(nums.length == 3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2 ;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        int max = dp[nums.length-2];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i =3 ;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        max = Math.max(max,dp[nums.length-1]);
        return max;

}
}