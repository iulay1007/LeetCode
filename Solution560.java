import java.util.HashMap;
import java.util.Map;

/*
560. 和为K的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
*/
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> map =new HashMap<>();
        map.put(0,1);
        int preSum=0;
        int count=0;
        for(int i:nums){
            preSum+=i;
            if(map.containsKey(preSum-k))
                count+=map.get(preSum-k);
            map.put(preSum,map.getOrDefault(preSum,0)+1);

        }
        return count;

    }
}
