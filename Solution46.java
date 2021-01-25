import java.util.ArrayList;
import java.util.List;
/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Solution46 {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track=new ArrayList<>();
        backtrack(nums,track);
        return result;
    }
    public void backtrack(int nums[],List<Integer> track){
        if(nums.length==track.size())
        {
            result.add(new ArrayList(track));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(track.contains(nums[i]))
                continue;
            track.add(nums[i]);
            backtrack(nums,track);
            track.remove(track.size()-1);
        }

    }
}