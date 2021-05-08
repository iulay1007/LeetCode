import java.util.HashMap;
import java.util.Map;

public class Solution523 {
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


