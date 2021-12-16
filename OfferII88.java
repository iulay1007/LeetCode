package 剑指offer;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 */
public class OfferII88 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);
        int[] sum = new int[cost.length];

        sum[0] = cost[0];
        sum[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            sum[i] = Math.min(sum[i - 1], sum[i - 2]) + cost[i];
        }
        return Math.min(sum[sum.length - 1], sum[sum.length - 2]);

    }

}
