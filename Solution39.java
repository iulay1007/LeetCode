/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track=new ArrayList<>();

        backtrack(candidates,target,0,track,0);
        return result;
    }
    void backtrack(int[] candidates, int target,int sum,List<Integer> track,int start){
        if(sum>target)
            return;
        if(sum==target)
        { result.add(new ArrayList<>(track));
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {

            List<Integer> temp=new ArrayList<>(track);
            int count=0;
            for(int j=1;j<=target/candidates[i];j++)
            {

                sum+=candidates[i];

                temp.add(candidates[i]);
                backtrack(candidates,target,sum,temp,i+1);
                count++;
            
            }
            sum-=candidates[i]*count;

        }


    }
}

