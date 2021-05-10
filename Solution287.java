import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 

示例 1：

输入：nums = [1,3,4,2,2]
输出：2
示例 2：

输入：nums = [3,1,3,4,2]
输出：3
示例 3：

输入：nums = [1,1]
输出：1
示例 4：

输入：nums = [1,1,2]
输出：1*/
public class Solution287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        for(int i : nums){
            if(set.contains(i))
                return i;
            set.add(i);

        }
        return 0;
    }

}

/*
二分法
https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
public class Solution {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right + 1) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num < mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，严格小于 4 的数的个数如果大于等于 4 个，
            // 此时重复元素一定出现在 [1, 3] 区间里

            if (cnt >= mid) {
                // 重复的元素一定出现在 [left, mid - 1] 区间里
                right = mid - 1;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid, right]
                // 注意：此时需要调整中位数的取法为上取整
                left = mid;
            }
        }
        return left;
    }
}*/