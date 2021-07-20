import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
1877. 数组中最大数对和的最小值
一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。

比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：

nums 中每个元素 恰好 在 一个 数对中，且
最大数对和 的值 最小 。
请你在最优数对划分的方案下，返回最小的 最大数对和 。



示例 1：

输入：nums = [3,5,2,3]
输出：7
解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
示例 2：

输入：nums = [3,5,4,2,4,6]
输出：8
解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8
 */

//确实有点笨笨的我
/*
为了使得最终的结果是各种排列组合的情况里最小的那个，很直观可以想到一种贪心的思想：让每个数对和的值尽可能平均。这样，即使取这些数对和中的最大者，也不会很大

怎么使得数对和的值尽可能平均呢？那就是：先排序，然后第一个和倒数一个组合，第二个和倒数第二个组合、……，最中间的两个相组合（因为题目保证 nums 的元素数量是偶数，所以不存在有元素会落单的情况）*/
public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result =Integer.MIN_VALUE;
        for(int i = 0 ,j=nums.length-1;i<nums.length/2;i++,j--)
        {
            result = Math.max(result,nums[i]+nums[j]);

        }
        return result;
    }

}


//回溯超内存了
/*
*   List<List<Integer>> result  = new ArrayList<>();

    public int minPairSum(int[] nums) {
            if(nums.length==2)
                return nums[1]+nums[0];
            int min = Integer.MAX_VALUE;
            List<Integer> track = new ArrayList<>();
            boolean used []  =new boolean[nums.length];
        Arrays.sort(nums);
            backtrack(nums,track,used);
            for(List<Integer> list : result){
                int f=1;
                int s =0;
                int mmin = 0;
                for(;f<list.size();f+=2,s+=2){
                    mmin = Math.max(mmin,list.get(f)+list.get(s));
                }
                min = Math.min(min,mmin);

            }
            return min;

    }
    void backtrack(int [] nums,List<Integer> track,boolean [] used){
            if(track.size() == nums.length){
                result.add(new ArrayList<>(track));
                return;
            }

            for(int i = 0 ; i<nums.length;i++){
                if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1]))
                    continue;
                used[i]=true;
                track.add(nums[i]);
                backtrack(nums,track,used);
                used[i]=false;
                track.remove(track.size()-1);

            }

    }
* */