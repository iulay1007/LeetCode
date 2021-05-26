import java.util.*;

/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



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
public class Solution47 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        Arrays.sort(nums);

        backtrack(nums, track, use);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> track, boolean[] use) {
        if (nums.length == track.size()) {
            List<Integer> temp = new ArrayList<>(track);
            result.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] || (i > 0 && nums[i] == nums[i - 1] && !use[i - 1])) {
                continue;
            }

            use[i] = true;
            track.add(nums[i]);
            backtrack(nums, track, use);
            track.remove(track.size() - 1);
            use[i] = false;
        }

    }
}
