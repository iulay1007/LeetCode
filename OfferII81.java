package 剑指offer;

import java.util.ArrayList;
import java.util.List;
/**给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。

 candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 

 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。

  

 示例 1：

 输入: candidates = [2,3,6,7], target = 7
 输出: [[7],[2,2,3]]
 示例 2：

 输入: candidates = [2,3,5], target = 8
 输出: [[2,2,2,2],[2,3,3],[3,5]]
 示例 3：

 输入: candidates = [2], target = 1
 输出: []
 示例 4：

 输入: candidates = [1], target = 1
 输出: [[1]]
*/
public class OfferII81 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return res;
    }

    void backtrack(int[] nums, int target, int s,List<Integer> path,int sum){
        if(target == sum ){
            res.add(new ArrayList<>(path));
        }
        else if(target<sum)
            return;
        for(int i =s ;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,target,i,new ArrayList<>(path),sum+nums[i]);
            path.remove(path.size()-1);
        }
    }
}