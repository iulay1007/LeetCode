package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer II 079. 所有子集
 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



 示例 1：

 输入：nums = [1,2,3]
 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 示例 2：

 输入：nums = [0]
 输出：[[],[0]]


 提示：

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 nums 中的所有元素 互不相同
 */
public class OfferII79 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums,0,new ArrayList<>());
        return res;
    }

    void backtrack(int[]nums,int s ,List<Integer> path){
        res.add(new ArrayList<>(path));

        for(int i =s ;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,i+1,new ArrayList<>(path));
            path.remove(path.size()-1);
        }

    }}
