package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer II 083. 没有重复元素集合的全排列
 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。



 示例 1：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 示例 2：

 输入：nums = [0,1]
 输出：[[0,1],[1,0]]
 示例 3：

 输入：nums = [1]
 输出：[[1]]


 提示：

 1 <= nums.length <= 6
 -10 <= nums[i] <= 10
 nums 中的所有整数 互不相同
 */
public class OfferII83 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    backtrack(nums,new ArrayList<>());
    return res;
    }

    void backtrack(int[] nums,List<Integer> path){
        if(nums.length == path.size())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtrack(nums,path);
            path.remove(path.size()-1);
        }
    }


}