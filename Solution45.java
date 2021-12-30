package 剑指offer;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Solution45 {
    //有的dp没有这么麻烦。。。。。。
    public int jump(int[] nums) {
            int n = nums.length;
            if(n ==1 &&nums[0]>=n)
                return 0;
            int[] dp = new int[n];
            for (int i = n - 1; i >= 0; i--){
                if (nums[i] == 0)
                    dp[i] = Integer.MAX_VALUE;
                else {
                    if(i == n-1){
                        dp[i] = 0;
                    }else if(i+nums[i]>=n-1){
                        dp[i] = 1;
                    }else {
                        dp[i] = dp[i+1];
                        for (int j =1;j<nums[i]&&i+j+1<n;j++){
                            int num =  dp[i+j+1];
                            dp[i] = Math.min(dp[i],num);
                        }
                        if(dp[i]!= Integer.MAX_VALUE)
                            dp[i]++;
                    }
                }
            }
            if(dp[0] == Integer.MAX_VALUE)
                return 0;
            return dp[0];
        }

}

/**
 *  public int jump(int[] nums) {
 int length = nums.length;
 int end = 0;
 int maxPosition = 0;
 int steps = 0;
 for (int i = 0; i < length - 1; i++) {
 maxPosition = Math.max(maxPosition, i + nums[i]);
 if (i == end) {
 end = maxPosition;
 steps++;
 }
 }
 return steps;
 }
 }
*/