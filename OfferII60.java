package 剑指offer;

import java.util.*;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。



 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]


 提示：

 1 <= nums.length <= 105
 k 的取值范围是 [1, 数组中不相同的元素的个数]
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

 */
public class OfferII60 {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int num : nums){
        map.put(num,map.getOrDefault(num,0)+1);
    }
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
        });

    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        int num = entry.getKey();
        int count = entry.getValue();
        if(priorityQueue.peek()!=null&&priorityQueue.size()>=k){
            if(count>priorityQueue.peek()[1])
            {
                priorityQueue.poll();
                priorityQueue.add(new Integer[]{num,count});

            }
        }else {
            priorityQueue.add(new Integer[]{num,count});
        }

    }
    int []res = new int[priorityQueue.size()];
    for(int i = 0;i<res.length;i++){
        res[i] = Objects.requireNonNull(priorityQueue.poll())[0];
    }
        return res;
    }

}
