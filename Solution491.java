import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。

 

示例：

输入：[4, 6, 7, 7]
输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 

提示：

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。*/
public class Solution491 {
    public List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {


        List <Integer> track = new ArrayList<Integer>();
        backtrack(nums,track,0);
        return result;
    }

    public void backtrack(int nums[],List<Integer> track,int s){
        if(track.size()>1&&!result.contains(track)){
        result.add(new ArrayList<>(track));
        }
        //本层去重
        Set<Integer> set = new HashSet<>();
        for(int i=s;i< nums.length;i++)
        {
            if(track.size()>0&&nums[i]<track.get(track.size()-1)||set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums,track,i+1);
            track.remove(track.size()-1);


        }

    }}