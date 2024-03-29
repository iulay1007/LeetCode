package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**594. 最长和谐子序列
 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。

 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。

 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。



 示例 1：

 输入：nums = [1,3,2,2,5,2,3,7]
 输出：5
 解释：最长的和谐子序列是 [3,2,2,2,3]
 示例 2：

 输入：nums = [1,2,3,4]
 输出：2
 示例 3：

 输入：nums = [1,1,1,1]
 输出：0*/
public class Solution594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        for (int key:map.keySet()){
            int temp = map.get(key);
            int t =map.getOrDefault(key+1,0);
            if( t ==0 )
                continue;
            max = Math.max(max,t+temp);
        }
        return max;
}
}
