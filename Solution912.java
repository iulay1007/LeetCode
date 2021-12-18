package 剑指offer;

import java.util.PriorityQueue;

/**
 * 912. 排序数组
 给你一个整数数组 nums，请你将该数组升序排列。



 示例 1：

 输入：nums = [5,2,3,1]
 输出：[1,2,3,5]
 示例 2：

 输入：nums = [5,1,1,2,0,0]
 输出：[0,0,1,1,2,5]
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num :nums)
            priorityQueue.add(num);
        for (int i = 0;i<nums.length;i++)
            nums[i] = priorityQueue.poll();

        return nums;
}
}