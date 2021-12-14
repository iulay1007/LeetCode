package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class OfferII82 {
    List<List<Integer>> res = new ArrayList<>();
    int used[];

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new int[candidates.length];
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;

    }

    void backtrack(int[] nums, int target, int s, List<Integer> path, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = s; i < nums.length; i++) {
            if (sum > target) return;
            if (i - 1 > 0 && used[i - 1] != 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums, target, i + 1, path, sum + nums[i]);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}