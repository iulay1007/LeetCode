import java.util.HashMap;
import java.util.Map;
/*523. 连续的子数组和
给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。

 

示例 1：

输入：[23,2,4,6,7], k = 6
输出：True
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2：

输入：[23,2,6,4,7], k = 6
输出：True
解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 

说明：*/
public class Solution523 {
    //前缀和:我们求数列的和时，Sn = a1+a2+a3+...an; 此时Sn就是数列的前 n 项和。例 S5 = a1 + a2 + a3 + a4 + a5; S2 = a1 + a2。所以我们完全可以通过 S5-S2 得到 a3+a4+a5 的值，这个过程就和我们做题用到的前缀和思想类似

/*0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1
0 到 i 的前缀和 preSum2 = 某常数2 * k + 余数2
当找到 余数1 等于 余数2时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) * k， 必为 k 的倍数， 返回true*/
    //官方题解：前缀和用hashmap取余优化
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }
    //超时
   /* public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }


        for (int left = 0; left < len - 1; left++) {
            for (int right = left + 1; right < len; right++) {
                int sum = preSum[right + 1] - preSum[left];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }*/
}


