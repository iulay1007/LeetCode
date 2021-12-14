package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。



 示例 1：

 输入：nums = [1,1,2]
 输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class OfferII84 {
    List<List<Integer>> res =  new ArrayList<>();
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used =  new int[nums.length];
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>());
        return res;
    }
    void backtrack(int []nums,List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i =0;i< nums.length;i++){
            if(used[i] ==1)
                continue;
            if(i-1>=0&&nums[i-1]==nums[i]&&used[i-1]!=1)
                continue;
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums,path);
            used[i] = 0;
            path.remove(path.size()-1);
        }
    }
}