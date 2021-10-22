import java.util.*;
/**229. 求众数 II
 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。





 示例 1：

 输入：[3,2,3]
 输出：[3]
 示例 2：

 输入：nums = [1]
 输出：[1]
 示例 3：

 输入：[1,1,1,3,3,2,2,2]
 输出：[1,2]
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int num = n/3;
        Arrays.sort(nums);
        for(int i = 0 ;i<n;i++){
            if(i+num<n){
                if(nums[i]==nums[i+num])
                {
                    if(list.size()==0||list.get(list.size()-1)!=nums[i])
                    list.add(nums[i]);
                    i = i+num;
                }
            }

        }
        return list;
    }
}

